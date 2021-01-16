package com.example.MPloin.Dto;

import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Document
@Component
public class LoginDto {
	
	@Id
	private Long id;
	@Field
	@NotEmpty
	@Email
	private String email;
	@Field
	@NotEmpty
	private String password;
	@Field
	@NotEmpty
	private List<String> ROLES;
	
}
