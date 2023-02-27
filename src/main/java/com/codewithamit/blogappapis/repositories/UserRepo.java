package com.codewithamit.blogappapis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewithamit.blogappapis.entities.User;

public interface UserRepo extends JpaRepository<User,Integer>{
    
}
