package com.codewithamit.blogappapis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.codewithamit.blogappapis.entities.Comment;

public interface CommentRepo extends JpaRepository <Comment,Integer>{
    
}
