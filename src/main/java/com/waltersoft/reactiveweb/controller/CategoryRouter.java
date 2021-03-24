package com.waltersoft.reactiveweb.controller;

import com.waltersoft.reactiveweb.domain.Category;
import com.waltersoft.reactiveweb.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Configuration
@RequiredArgsConstructor
@Slf4j
public class CategoryRouter {

    private final CategoryRepository categoryRepository;

    @Bean
    public RouterFunction<ServerResponse> getAllCategoriesRoute() {
        return route(
                GET("/category"),
                    req ->ok().body(
                            categoryRepository.findAll().filter(c->c.getName().equals("Planes")),
                            Category.class)
        );
    }
}
