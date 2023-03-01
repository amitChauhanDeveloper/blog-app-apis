package com.codewithamit.blogappapis.servicesImpl;

import org.springframework.stereotype.Service;

import com.codewithamit.blogappapis.payloads.CommentDto;
import com.codewithamit.blogappapis.repositories.PostRepo;
import com.codewithamit.blogappapis.repositories.CommentRepo;
import com.codewithamit.blogappapis.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import com.codewithamit.blogappapis.entities.Post;
import com.codewithamit.blogappapis.exceptions.RecourceNotFoundException;
import org.modelmapper.ModelMapper;
import com.codewithamit.blogappapis.entities.Comment;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private PostRepo postRepo;

    @Autowired
    private CommentRepo commentRepo;

    @Autowired
    private ModelMapper modelMapper;

    //create comment
    @Override
    public CommentDto createComment(CommentDto commentDto, Integer postId) {
        Post post = this.postRepo.findById(postId)
                .orElseThrow(() -> new RecourceNotFoundException("Post", "Post id", postId));
        Comment comment = this.modelMapper.map(commentDto, Comment.class);
        comment.setPost(post);
        Comment savedComment = this.commentRepo.save(comment);
        return this.modelMapper.map(savedComment, CommentDto.class);
    }

    //delete comment
    @Override
    public void deleteComment(Integer commentId) {
        Comment com = this.commentRepo.findById(commentId)
                .orElseThrow(() -> new RecourceNotFoundException("Comment", "Comment id", commentId));
        this.commentRepo.delete(com);
    }

}
