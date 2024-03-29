package com.codewithamit.blogappapis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codewithamit.blogappapis.payloads.ApiResponse;
import com.codewithamit.blogappapis.payloads.CommentDto;
import com.codewithamit.blogappapis.services.CommentService;

@RestController
@RequestMapping("/api/v1/")
public class CommentController {

    @Autowired
    private CommentService commentService;

    /* // create comment
    @PostMapping("/post/{postId}/users/{userId}/comments")
    public ResponseEntity<CommentDto> createComment(@Valid @RequestBody CommentDto commentDto,
            @PathVariable Integer postId,
            @PathVariable Integer userId) {
        CommentDto createComment = this.commentService.createComment(commentDto, postId,userId);
        return new ResponseEntity<CommentDto>(createComment, HttpStatus.CREATED);
    } */

    // create comment
    @PostMapping("/post/{postId}/comments")
    public ResponseEntity<CommentDto> createComment(@RequestBody CommentDto commentDto,
            @PathVariable Integer postId) {
        CommentDto createComment = this.commentService.createComment(commentDto, postId);
        return new ResponseEntity<CommentDto>(createComment, HttpStatus.CREATED);
    }

    // update comment
    @PutMapping("/comments/{commentId}")
    public ResponseEntity<CommentDto> updateComment(@RequestBody CommentDto commentDto,
            @PathVariable Integer commentId) {
        CommentDto updatedComment = this.commentService.updateComment(commentDto, commentId);
        return ResponseEntity.ok(updatedComment);

    }

    // delete comment
    @DeleteMapping("comments/{commentId}")
    public ResponseEntity<ApiResponse> deleteComment(@PathVariable Integer commentId) {
        this.commentService.deleteComment(commentId);
        return new ResponseEntity<ApiResponse>(new ApiResponse("Comment Deleted Successfully!", true), HttpStatus.OK);
    }

}
