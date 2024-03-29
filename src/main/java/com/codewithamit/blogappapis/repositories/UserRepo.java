package com.codewithamit.blogappapis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewithamit.blogappapis.entities.User;
import java.util.Optional;

public interface UserRepo extends JpaRepository<User,Integer>{
 
    Optional<User> findByEmail (String email);
}
