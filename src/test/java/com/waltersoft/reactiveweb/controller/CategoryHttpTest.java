package com.waltersoft.reactiveweb.controller;

import com.waltersoft.reactiveweb.domain.Category;
import com.waltersoft.reactiveweb.repository.CategoryRepository;
import com.waltersoft.reactiveweb.service.CategoryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.testcontainers.junit.jupiter.Testcontainers;
import reactor.core.publisher.Flux;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@WebFluxTest
@Testcontainers
public class CategoryHttpTest {

    @MockBean
    CategoryRepository repository;

    @MockBean
    CategoryService service;

    @Autowired
    private WebTestClient client;

    @Test
    public void getAllCategories(){

        Mockito.when(this.repository.findAll())
                .thenReturn(Flux.just(new Category().setName("Fred")));

        client.get()
                .uri("/acategory/all")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBodyList(Category.class)
                .consumeWith(response ->{
                    assertThat(response.getResponseBody()).isNotNull();
                    List<Category> catsRead = response.getResponseBody();
                    assertThat(catsRead).isNotNull();
                    assertThat(catsRead).isNotEmpty();
                    assertThat(catsRead.size()).isEqualTo(1L);
                    //assertThat(catsRead.size()).is( new Condition<>(c -> c>1, "largerThan1"));
                });

    }

}
