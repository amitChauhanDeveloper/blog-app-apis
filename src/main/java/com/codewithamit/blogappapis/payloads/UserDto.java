package com.codewithamit.blogappapis.payloads;

import java.util.ArrayList;
import java.util.List;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UserDto {

    private int id;

    @NotEmpty
    @Size(min = 4 ,message = "Username must be min of 4 characters !")
    private String name;

    @Email(message = "Email address is not valid !")
    private String email;

    @NotEmpty
    @Size(min = 3, max = 10, message = "Password must be min of 3 chars and max of 10 chars !")
    //@Pattern(regexp = " ")
    private String password;

    @NotEmpty
    private String about;

    private List<RoleDto> roles = new ArrayList<>();

    @JsonIgnore
	public String getPassword() {
		return this.password;
	}
	
	@JsonProperty
	public void setPassword(String password) {
		this.password=password;
	}
    
}