package com.codewithamit.blogappapis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.codewithamit.blogappapis.entities.Category;

public interface CategoryRepo extends JpaRepository<Category,Integer>{
    
}
