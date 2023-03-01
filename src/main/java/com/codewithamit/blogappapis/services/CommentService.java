package com.codewithamit.blogappapis.services;

import com.codewithamit.blogappapis.payloads.CommentDto;

public interface CommentService {
    
    //create comment

    CommentDto createComment (CommentDto commentDto, Integer postId, Integer userId);

    

    //delete comment
    void deleteComment(Integer commentId);
}
