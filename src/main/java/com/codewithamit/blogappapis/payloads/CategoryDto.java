package com.codewithamit.blogappapis.payloads;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CategoryDto {
    
    private int categoryId;

    @NotEmpty
    @Size(min = 4 ,message = "Category must be min of 4 characters !")
    private String categoryTitle;

    @NotEmpty
    @Size(min = 10, max = 500, message = "Description must be min of 10 chars and max of 500 chars !")
    private String categoryDescription;
}
