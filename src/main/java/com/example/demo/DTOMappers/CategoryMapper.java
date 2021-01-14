package com.example.demo.DTOMappers;

import com.example.demo.DTOs.CategoryDTO;
import com.example.demo.Entities.Category;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryDTO toCategoryDTO(Category category);
    Category toCategory(CategoryDTO categoryDTO);
    List<CategoryDTO> toCategoryDTOs(List<Category> categoryList);
}
