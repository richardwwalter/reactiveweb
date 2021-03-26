package com.waltersoft.reactiveweb;

import com.waltersoft.reactiveweb.domain.Category;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Condition;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ContextConfiguration
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ReactivewebApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Testcontainers
@RequiredArgsConstructor
@Slf4j
class ReactivewebApplicationTests {

	@Autowired
	private WebTestClient webTestClient;

	@Test
	public void getCategoriesTest(){
		webTestClient.get()
				.uri("/category")
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
				});

	}

	@Test
	public void getAllCategoriesTest(){
		webTestClient.get()
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
					assertThat(catsRead.size()).isEqualTo(5L);
					assertThat(catsRead.size()).is( new Condition<>(c -> c>1, "largerThan1"));
				});
	}

}
