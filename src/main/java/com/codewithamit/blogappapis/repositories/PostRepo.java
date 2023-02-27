package com.codewithamit.blogappapis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewithamit.blogappapis.entities.Post;

public interface PostRepo extends JpaRepository<Post,Integer>{
    
}
