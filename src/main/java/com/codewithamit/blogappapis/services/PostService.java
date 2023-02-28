package com.codewithamit.blogappapis.services;

import com.codewithamit.blogappapis.payloads.PostDto;
import com.codewithamit.blogappapis.payloads.PostResponse;
import java.util.List;

public interface PostService {

    //create
    PostDto createPost (PostDto postDto, Integer userId, Integer categoryId);

    //update
    PostDto updatePost (PostDto postDto, Integer postId);

     //delete
     void deletePost (Integer postId);

    //get single post
    PostDto getPostById (Integer postId);

    //get all post
    PostResponse getAllPost(Integer pageNumber, Integer pageSize, String sortBy, String sortDir);

    //get all posts by category
    List <PostDto> getPostsByCategory (Integer categoryId);

    //get all posts by users
    List <PostDto> getPostsByUser (Integer userId);

    // search posts
    List <PostDto> searchPosts(String keyword);
   
    
}
