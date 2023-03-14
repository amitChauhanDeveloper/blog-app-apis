package com.codewithamit.blogappapis.payloads;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@NoArgsConstructor

public class PostDto {

    private int postId;
    
    @NotEmpty
    @Size(min = 4 ,message = "Title must be min of 4 characters !")
    private String title;

    @NotEmpty
    @Size(min = 10 ,message = "Content must be min of 4 characters !")
    private String content;

    @NotEmpty
    private String imageName;

    private Date addedDate;
    private CategoryDto category;
    private UserDto user;

    private List<CommentDto> comments = new ArrayList<>();
    
}
