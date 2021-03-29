package com.waltersoft.reactiveweb.controller;

import com.waltersoft.reactiveweb.domain.Category;
import com.waltersoft.reactiveweb.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;
import static org.springdoc.core.fn.builders.apiresponse.Builder.responseBuilder;

@Configuration
@RequiredArgsConstructor
@Slf4j
public class CategoryWebFluxFunctionalRouter {

  private final CategoryRepository categoryRepository;
  /*
     @Bean
     @RouterOperation(beanClass = CategoryRepository.class, beanMethod = "findAll")
     public RouterFunction<ServerResponse> getAllCategoriesRoute() {
         return route(
                 GET("/category")
                 .and(accept(MediaType.APPLICATION_JSON))
                 .and(contentType(MediaType.APPLICATION_JSON)),
                 req -> ok().body(
                     categoryRepository.findAll().filter(c->c.getName().equals("Planes")),
                     Category.class)
         );
     }
  */

  @Bean
  // @RouterOperation(beanClass = CategoryRepository.class, beanMethod = "findAll")
  public RouterFunction<ServerResponse> routes() {
    return org.springdoc.webflux.core.fn.SpringdocRouteBuilder.route()
        .GET(
            "/categoryb",
            // contentType(MediaType.APPLICATION_JSON).and(accept(MediaType.APPLICATION_JSON)),
            req ->
                ok().body(
                        categoryRepository.findAll().filter(c -> c.getName().equals("Planes")),
                        Category.class),
            ops ->
                ops.operationId("categoryb")
                    // .parameter(parameterBuilder().name("key1").description("My key1
                    // description"))
                    // .parameter(parameterBuilder().name("key2").description("My key2
                    // description"))
                    .response(
                        responseBuilder()
                            .responseCode("200")
                            .description("This is normal response description")
                            .implementationArray(Category.class))
                    .response(
                        responseBuilder()
                            .responseCode("404")
                            .description("This is another response description")))
        .GET(
            "/category",
            // accept(MediaType.APPLICATION_JSON),
            req ->
                ok().body(
                        categoryRepository.findAll().filter(c -> c.getName().equals("Planes")),
                        Category.class),
            ops ->
                ops.operationId("category")
                    // .parameter(parameterBuilder().name("key1").description("My key1
                    // description"))
                    // .parameter(parameterBuilder().name("key2").description("My key2
                    // description"))
                    .response(
                        responseBuilder()
                            .responseCode("200")
                            .description("This is normal response description")
                            .implementationArray(Category.class))
                    .response(
                        responseBuilder()
                            .responseCode("404")
                            .description("This is another response description")))
        .build();
  }
}
