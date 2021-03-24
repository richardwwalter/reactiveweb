package com.waltersoft.reactiveweb;

import com.waltersoft.reactiveweb.domain.Category;
import com.waltersoft.reactiveweb.service.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import reactor.core.publisher.Mono;

@SpringBootApplication
@EnableR2dbcRepositories
@RequiredArgsConstructor
@Slf4j
public class ReactivewebApplication {

	private final CategoryService service;

	public static void main(String[] args) {
		SpringApplication.run(ReactivewebApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void initiatePushDataFlow() {
		save();
	}

	private void save(){
		Category newCategory = Category.builder().name("SpaceShip").build();
		Mono<Category> savedCat =  service.save(newCategory);
		savedCat.subscribe(c->log.info("Saved {}",c));
	}

}
