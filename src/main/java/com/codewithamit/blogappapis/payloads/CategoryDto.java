package com.codewithamit.blogappapis.payloads;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CategoryDto {
    
    private int categoryId;
    private String categoryTitle;
    private String categoryDescription;
}
