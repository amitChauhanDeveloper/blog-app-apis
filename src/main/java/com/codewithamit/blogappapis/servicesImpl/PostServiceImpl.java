package com.codewithamit.blogappapis.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codewithamit.blogappapis.services.PostService;
import com.codewithamit.blogappapis.entities.Post;
import com.codewithamit.blogappapis.entities.User;
import com.codewithamit.blogappapis.entities.Category;
import com.codewithamit.blogappapis.payloads.PostDto;
import com.codewithamit.blogappapis.repositories.PostRepo;
import com.codewithamit.blogappapis.repositories.UserRepo;
import com.codewithamit.blogappapis.repositories.CategoryRepo;
import com.codewithamit.blogappapis.exceptions.RecourceNotFoundException;


import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;

@Service
public class PostServiceImpl implements PostService{

    @Autowired
    private PostRepo postRepo;

    @Autowired
    private ModelMapper modelMapper; 

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private CategoryRepo categoryRepo;

    @Override
    public PostDto createPost(PostDto postDto, Integer userId, Integer categoryId) {

        User user = this.userRepo.findById(userId).orElseThrow(()-> new RecourceNotFoundException("User", "User id", userId));

        Category category = this.categoryRepo.findById(categoryId).orElseThrow(()-> new RecourceNotFoundException("Category", "Category id", categoryId));

        Post post = this.modelMapper.map(postDto, Post.class);
        post.setImageName("default.png");
        post.setAddedDate(new Date());
        post.setUser(user);
        post.setCategory(category);

        Post newPost = this.postRepo.save(post);
        return this.modelMapper.map(newPost, PostDto.class); // check this line
    }

    @Override
    public void deletePost(Post postId) {
        
        
    }

    @Override
    public List<PostDto> getAllPost() {
        
        return null;
    }

    @Override
    public PostDto getPostById(Integer postId) {
       
        return null;
    }

    @Override
    public List<Post> getPostsByCategory(Integer categoryId) {
        
        return null;
    }

    @Override
    public List<Post> getPostsByUser(Integer userId) {
        
        return null;
    }

    @Override
    public List<Post> searchPosts(String keyword) {
        
        return null;
    }

    @Override
    public PostDto updatePost(PostDto post, Integer postId) {
        
        return null;
    }

    



    
}
