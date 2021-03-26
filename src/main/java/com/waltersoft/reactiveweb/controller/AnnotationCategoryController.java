package com.waltersoft.reactiveweb.controller;

import com.waltersoft.reactiveweb.domain.Category;
import com.waltersoft.reactiveweb.repository.CategoryRepository;
import com.waltersoft.reactiveweb.service.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@Configuration
@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("acategory")
public class AnnotationCategoryController {

    private final CategoryService service;
    private final CategoryRepository categoryRepository;

    @GetMapping("all")
    public Flux<Category> getAll(){
        return this.categoryRepository.findAll();
    }

    @GetMapping("{categoryId}")
    public Mono<ResponseEntity<Category>> getCategoryById(@PathVariable int categoryId){
        return this.categoryRepository.findById(categoryId)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Mono<Category> createCategory(@RequestBody @Valid Mono<Category> categoryMono){
        return categoryMono.flatMap(this.categoryRepository::save);
    }

    @PutMapping("{categoryId}")
    public Mono<Category> updateCategory(@PathVariable int categoryId, @RequestBody @Valid Mono<Category> categoryMono){
        return service.updateCategory(categoryId, categoryMono);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteCategory(@PathVariable int id){
        return this.categoryRepository.deleteById(id);
    }

}

