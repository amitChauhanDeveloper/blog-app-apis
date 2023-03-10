package com.codewithamit.blogappapis.services;

import java.util.List;

import com.codewithamit.blogappapis.payloads.UserDto;

public interface UserService {

    //user register
    UserDto registerNewUser (UserDto user);
    //create
    UserDto createUser(UserDto user);

    //update
    UserDto updateUser(UserDto userDto, Integer userId);

    //get single user
    UserDto getUserById(Integer userId);

    //get all users
    List<UserDto> getAllUsers();

    //delete
    Void deleteUser(Integer userId);

}
