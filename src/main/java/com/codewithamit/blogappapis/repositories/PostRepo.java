package com.codewithamit.blogappapis.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.codewithamit.blogappapis.entities.Post;
import com.codewithamit.blogappapis.entities.User;
import com.codewithamit.blogappapis.entities.Category;

public interface PostRepo extends JpaRepository<Post,Integer>{

    // Custom finder method 
    List<Post> findByUser(User user);
    List<Post> findByCategory(Category category);
    
    List<Post> findByTitleContaining (String title);
    
}
