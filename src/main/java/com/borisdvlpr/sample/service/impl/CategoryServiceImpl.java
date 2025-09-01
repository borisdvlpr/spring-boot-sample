package com.borisdvlpr.sample.service.impl;

import com.borisdvlpr.sample.domain.entities.Category;
import com.borisdvlpr.sample.repository.CategoryRepository;
import com.borisdvlpr.sample.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Override
    public List<Category> listCategories() {
        return categoryRepository.findAllWithPostCount();
    }
}
