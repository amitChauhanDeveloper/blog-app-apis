package com.codewithamit.blogappapis.services;

import com.codewithamit.blogappapis.payloads.CategoryDto;
import java.util.List;

public interface CategoryService {
    

    CategoryDto createCategory(CategoryDto category);

    CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId);

    CategoryDto getCategory(Integer categoryId);

    List<CategoryDto> getCategories();

    Void deleteCategory(Integer categoryId);

}
