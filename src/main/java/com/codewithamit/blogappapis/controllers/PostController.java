package com.codewithamit.blogappapis.controllers;

import org.springframework.web.bind.annotation.RestController;
import com.codewithamit.blogappapis.payloads.PostDto;
import com.codewithamit.blogappapis.services.PostService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("api")
public class PostController {

    @Autowired
    private PostService postService;
    // create
    @PostMapping("/user/{userId}/category/{categoryId}/posts")
    public ResponseEntity <PostDto> createPost(
        @Valid @RequestBody PostDto postDto,
        @PathVariable Integer userId,
        @PathVariable Integer categoryId
        )
    {
        PostDto createPost = this.postService.createPost(postDto, userId, categoryId);
        return new ResponseEntity<PostDto>(createPost,HttpStatus.CREATED);
    }
    //update
    //delete
    //get
    //get all
    
}
