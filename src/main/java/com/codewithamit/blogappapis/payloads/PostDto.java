package com.codewithamit.blogappapis.payloads;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

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
    
}
