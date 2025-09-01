package com.borisdvlpr.sample.controller;

import com.borisdvlpr.sample.domain.dto.CategoryDTO;
import com.borisdvlpr.sample.domain.entities.Category;
import com.borisdvlpr.sample.mapper.CategoryMapper;
import com.borisdvlpr.sample.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;
    private final CategoryMapper categoryMapper;

    @GetMapping
    public ResponseEntity<List<CategoryDTO>> listCategories() {
        List<CategoryDTO> categories = categoryService.listCategories().stream()
                .map(categoryMapper::toDTO)
                .toList();

        return ResponseEntity.ok(categories);
    }
}
