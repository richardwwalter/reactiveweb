package com.waltersoft.reactiveweb.repository;

import com.waltersoft.reactiveweb.domain.Category;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.r2dbc.DataR2dbcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.testcontainers.junit.jupiter.Testcontainers;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

@RunWith(SpringRunner.class)
@DataR2dbcTest
@Testcontainers
public class CategoryRepositoryTests {

  @Autowired private CategoryRepository repository;

  @Test
  public void persistTest() {
    Category cat = new Category().setName("Fred");

    Flux<Category> catFlux =
        repository
            .deleteAll() // delete all
            .then(repository.save(cat)) // save
            .thenMany(repository.findAll()); // find

    StepVerifier.create(catFlux).expectNextCount(1).verifyComplete();
  }
}
