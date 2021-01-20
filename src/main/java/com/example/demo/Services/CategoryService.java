package com.example.demo.Services;

import com.example.demo.Entities.Category;
import com.example.demo.Repositories.CategoryRepo;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class CategoryService {

    private CategoryRepo categoryRepo;

    public CategoryService(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    public boolean save(@RequestBody Category category) {
        if (categoryRepo.isCategoryAdded(category.getCategory())) {
            return false;
        } else {
            categoryRepo.save(category);
            return true;
        }
    }

    public List<Category> findAll() {
        return (List<Category>) categoryRepo.findAll();
    }

    public List<Category> findByGameId(@PathVariable int gameId) {
        return categoryRepo.findByGameId(gameId);
    }
}
