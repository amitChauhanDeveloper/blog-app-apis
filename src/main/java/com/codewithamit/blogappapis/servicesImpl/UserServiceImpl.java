package com.codewithamit.blogappapis.servicesImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.codewithamit.blogappapis.config.AppConstants;
import com.codewithamit.blogappapis.entities.Role;
import com.codewithamit.blogappapis.entities.User;
import com.codewithamit.blogappapis.exceptions.RecourceNotFoundException;
import com.codewithamit.blogappapis.payloads.UserDto;
import com.codewithamit.blogappapis.repositories.RoleRepo;
import com.codewithamit.blogappapis.repositories.UserRepo;
import com.codewithamit.blogappapis.services.UserService;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepo userRepo;

  @Autowired
  private ModelMapper modelMapper;

  @Autowired
  private PasswordEncoder passwordEncoder; 

  @Autowired
  private RoleRepo roleRepo;
  
  // create user

  @Override
  public UserDto createUser(UserDto userDto) {
    User user = this.dtoToUser(userDto);
    User savedUser = this.userRepo.save(user);
    return this.userToDto(savedUser);
  }

  // update user

  @Override
  public UserDto updateUser(UserDto userDto, Integer userId) {

    User user = this.userRepo.findById(userId)
        .orElseThrow(() -> new RecourceNotFoundException("User", "Id", userId));

    user.setName(userDto.getName());
    user.setEmail(userDto.getEmail());
    user.setPassword(userDto.getPassword());
    user.setAbout(userDto.getAbout());

    User updateUser = this.userRepo.save(user);
    UserDto userDto1 = this.userToDto(updateUser);
    return userDto1;
  }

  // get user by id

  @Override
  public UserDto getUserById(Integer userId) {

    User user = this.userRepo.findById(userId).orElseThrow( () -> new RecourceNotFoundException("User", "Id", userId));
    return this.userToDto(user);
  }

  // get all users

  @Override
  public List<UserDto> getAllUsers() {

    List<User> users = this.userRepo.findAll();
    List<UserDto> userDtos = users.stream().map(user -> this.userToDto(user)).collect(Collectors.toList());
    return userDtos;
  }

  // delete user
  
  @Override
  public Void deleteUser(Integer userId) {

    User user = this.userRepo.findById(userId).orElseThrow(() -> new RecourceNotFoundException("user", "Id", userId));
    this.userRepo.delete(user);
    return null;
  }

  // method for convert dto to entity
  private User dtoToUser(UserDto userDto) {
    User user = this.modelMapper.map(userDto, User.class);

    /*user.setId(userDto.getId());
    user.setName(userDto.getName());
    user.setEmail(userDto.getEmail());
    user.setPassword(userDto.getPassword());
    user.setAbout(userDto.getAbout()); */

    return user;
  }

  // method for convert entity to dto

  public UserDto userToDto(User user) {
    UserDto userDto = this.modelMapper.map(user, UserDto.class);

   /*userDto.setId(user.getId());
    userDto.setName(user.getName());
    userDto.setEmail(user.getEmail());
    userDto.setPassword(user.getPassword());
    userDto.setAbout(user.getAbout()); */

    return userDto;
  }

  @Override
  public UserDto registerNewUser(UserDto userDto) {
    User user = this.modelMapper.map(userDto, User.class);

    //encoded the password
    user.setPassword(this.passwordEncoder.encode(user.getPassword()));

    //roles
    Role role = this.roleRepo.findById(AppConstants.NORMAL_USER).get();
    user.getRoles().add(role);
    User newUser = this.userRepo.save(user);
    return this.modelMapper.map(newUser, UserDto.class);
  }
}
