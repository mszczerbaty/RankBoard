package com.example.demo.Controllers;


import com.example.demo.DTOMappers.CategoryMapper;
import com.example.demo.DTOs.CategoryDTO;
import com.example.demo.Entities.Category;
import com.example.demo.Services.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200/", allowedHeaders = "*")
@RequestMapping("/categories")
public class CategoryController {

    private CategoryMapper categoryMapper;
    private CategoryService categoryService;

    public CategoryController(CategoryMapper categoryMapper, CategoryService categoryService) {
        this.categoryMapper = categoryMapper;
        this.categoryService = categoryService;
    }

    @GetMapping()
    public ResponseEntity<List<CategoryDTO>> getCategories() {
        return ResponseEntity.ok(categoryMapper.toCategoryDTOs(categoryService.findAll()));
    }

    @GetMapping("/game/{gameId}")
    public ResponseEntity<List<CategoryDTO>> getCategoriesByGame(@PathVariable int gameId) {
        return ResponseEntity.ok(categoryMapper.toCategoryDTOs(categoryService.findByGameId(gameId)));
    }

    @PostMapping()
    ResponseEntity<CategoryDTO> addCategory(@RequestBody CategoryDTO categoryDTO) {
        Category category = categoryMapper.toCategory(categoryDTO);
        categoryService.save(category);
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryDTO);
    }

    @PutMapping("/{categoryId}")
    ResponseEntity<CategoryDTO> updateCategory(@PathVariable int categoryId, @RequestBody CategoryDTO categoryDTO) {
        if (categoryService.save(categoryMapper.toCategory(categoryDTO))) {
            return ResponseEntity.status(HttpStatus.CREATED).body(categoryDTO);
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(categoryDTO);
        }
    }



}
