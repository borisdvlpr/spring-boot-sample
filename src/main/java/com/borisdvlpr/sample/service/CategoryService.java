package com.borisdvlpr.sample.service;

import com.borisdvlpr.sample.domain.entities.Category;

import java.util.List;

public interface CategoryService {
    List<Category> listCategories();
    Category createCategory(Category category);
}
