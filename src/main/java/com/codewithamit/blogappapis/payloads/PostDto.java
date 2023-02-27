package com.codewithamit.blogappapis.payloads;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class PostDto {

    private int postId;
    private String title;
    private String content;
    private String imageName;
    private Date addedDate;
    
}
