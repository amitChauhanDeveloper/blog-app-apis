package com.codewithamit.blogappapis.servicesImpl;

import com.codewithamit.blogappapis.entities.Category;
import com.codewithamit.blogappapis.payloads.CategoryDto;
import com.codewithamit.blogappapis.repositories.CategoryRepo;
import com.codewithamit.blogappapis.services.CategoryService;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codewithamit.blogappapis.exceptions.RecourceNotFoundException;

@Service
public class CategoryServiceImpl implements CategoryService {

  @Autowired
  private CategoryRepo categoryRepo;

  @Autowired
  private ModelMapper modelMapper;

  // Create category

  @Override
  public CategoryDto createCategory(CategoryDto categoryDto) {
    Category category = this.modelMapper.map(categoryDto, Category.class);
    Category addedCategory = this.categoryRepo.save(category);
    return this.modelMapper.map(addedCategory, CategoryDto.class);
  }

  // update category

  @Override
  public CategoryDto updateCategory (CategoryDto categoryDto,Integer categoryId) {
    Category category = this.categoryRepo.findById(categoryId)
        .orElseThrow(() -> new RecourceNotFoundException("Category", "category id", categoryId));

    category.setCategoryTitle(categoryDto.getCategoryTitle());
    category.setCategoryDescription(categoryDto.getCategoryDescription());

    Category updateCategory = this.categoryRepo.save(category);
    return this.modelMapper.map(updateCategory, CategoryDto.class);
  }

  // get category

  @Override
  public CategoryDto getCategory(Integer categoryId) {
    Category category = this.categoryRepo.findById(categoryId)
        .orElseThrow(() -> new RecourceNotFoundException("Category", "category id", categoryId));
    return this.modelMapper.map(category, CategoryDto.class);
  }

  // get all categories
  
  @Override
  public List<CategoryDto> getCategories() {
    List<Category> categories = this.categoryRepo.findAll();
    List<CategoryDto> categoryDto = categories.stream().map((category) -> this.modelMapper.map(category, CategoryDto.class)).collect(Collectors.toList());
    return categoryDto;
  }

  // delete category

  @Override
  public Void deleteCategory(Integer categoryId) {
    Category category = this.categoryRepo.findById(categoryId)
        .orElseThrow(() -> new RecourceNotFoundException("category", "category id", categoryId));
    this.categoryRepo.delete(category);
    return null;
  }

  /* // method for convert dto to entity
  private Category dtoToCategory(CategoryDto categoryDto) {
    Category category = this.modelMapper.map(categoryDto, Category.class);
    return category;
  }

  // method for convert entity to dto

  public CategoryDto categoryToDto(Category category) {
    CategoryDto categoryDto = this.modelMapper.map(category, CategoryDto.class);
    return categoryDto;
  } */
}
