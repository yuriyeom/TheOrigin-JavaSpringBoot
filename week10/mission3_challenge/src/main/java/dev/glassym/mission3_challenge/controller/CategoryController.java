package dev.glassym.mission3_challenge.controller;

import dev.glassym.mission3_challenge.model.CategoryDto;
import dev.glassym.mission3_challenge.service.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Profile("category")
@RestController
@RequestMapping("category")
public class CategoryController {
    private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto){
        return ResponseEntity.ok(this.categoryService.createCategory(categoryDto));
    }

    @GetMapping("{id}")
    public ResponseEntity<CategoryDto> readCategory(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.categoryService.readCategory(id));
    }

    @GetMapping
    public ResponseEntity<Collection<CategoryDto>> readCategoryAll(){
        return ResponseEntity.ok(this.categoryService.readCategoryAll());
    }
}