package com.codewithamit.blogappapis.services;

import com.codewithamit.blogappapis.payloads.CategoryDto;
import java.util.List;

public interface CategoryService {
    
    // create
    CategoryDto createCategory(CategoryDto category);

    //update
    CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId);

    //get single category
    CategoryDto getCategory(Integer categoryId);

    //get all categories
    List<CategoryDto> getCategories();

    //delete
    Void deleteCategory(Integer categoryId);

}
