package com.ofss.filehandling.Security;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

	@Id
	@GeneratedValue( strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "username", unique = true)
	@NotBlank
	private String username;
	
	@Column(name = "password")
	@NotBlank
	private String password;
	
}
