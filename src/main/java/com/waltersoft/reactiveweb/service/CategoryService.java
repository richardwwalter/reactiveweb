package com.waltersoft.reactiveweb.service;

import com.waltersoft.reactiveweb.domain.Category;
import com.waltersoft.reactiveweb.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Transactional
    public Mono<Category> save(Category category){
        return categoryRepository.save(category);
    }

    @Transactional
    public Mono<Category> updateCategory(int categoryId, final Mono<Category> categoryMono){
        return categoryRepository.findById(categoryId)
                .flatMap(c -> categoryMono.map(u -> {
                    c.setName(u.getName());
                    return c;
                }))
                .flatMap(categoryRepository::save);
    }

}
