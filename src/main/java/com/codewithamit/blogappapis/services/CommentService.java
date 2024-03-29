package com.codewithamit.blogappapis.services;

import com.codewithamit.blogappapis.payloads.CommentDto;

public interface CommentService {
    
    //create comment

    //CommentDto createComment (CommentDto commentDto, Integer postId, Integer userId);

    CommentDto createComment (CommentDto commentDto, Integer postId);

    //update comment
    CommentDto updateComment(CommentDto commentDto,Integer commentId);
    

    //delete comment
    void deleteComment(Integer commentId);
}
