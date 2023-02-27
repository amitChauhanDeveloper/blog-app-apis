package com.codewithamit.blogappapis.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RecourceNotFoundException extends RuntimeException{
    

    String resourceName;
    String fieldName;
    long fieldValue;

    public RecourceNotFoundException(String recourceName,String fieldName, long fieldValue){
        super(String.format("%s not found with %s : %s",recourceName, fieldName, fieldValue));
        this.resourceName = recourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

}
