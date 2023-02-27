package com.codewithamit.blogappapis.services;

import java.util.List;

import com.codewithamit.blogappapis.payloads.UserDto;

public interface UserService {

    UserDto createUser(UserDto user);

    UserDto updateUser(UserDto userDto, Integer userId);

    UserDto getUserById(Integer userId);

    List<UserDto> getAllUsers();

    Void deleteUser(Integer userId);

}
