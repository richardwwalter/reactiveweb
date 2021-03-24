package com.waltersoft.reactiveweb.repository;

import com.waltersoft.reactiveweb.domain.Category;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface CategoryRepository extends ReactiveCrudRepository<Category,Integer> {
}
