package com.codewithamit.blogappapis.services;

import com.codewithamit.blogappapis.payloads.PostDto;
import com.codewithamit.blogappapis.entities.Post;
import java.util.List;

public interface PostService {

    //create
    PostDto createPost (PostDto postDto, Integer userId, Integer categoryId);

    //update
    PostDto updatePost (PostDto post, Integer postId);

     //delete
     void deletePost (Post postId);

    //get single post
    PostDto getPostById (Integer postId);

    //get all post
    List <PostDto> getAllPost();

    //get all posts by category
    List <Post> getPostsByCategory (Integer categoryId);

    //get all posts by users
    List <Post> getPostsByUser (Integer userId);

    // search posts
    List <Post> searchPosts(String keyword);
   
    
}
