package com.example.MPloin.Entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Document
@AllArgsConstructor
@NoArgsConstructor
public @Data class Employee {
	
	@Id
	private String id;
	
	@NotBlank(message = "Name is mandatory")
	private String empl_name;
	
	@Indexed(unique = true)
	@NotBlank(message = "Email is mandatory")
	private String email;
	
	@NotBlank(message = "Password is mandatory")
	private String password;
	
	@NotBlank(message = "Gender is mandatory")
	private String gender;
	/*
	 * 
	 * 
	 * @NotBlank(message = "Company Name is mandatory") private String company;
	 * 
	 * 
	 * 
	 * @NotBlank(message = "Team Name is mandatory") private String team_name;
	 */
//	 
//	private Long team_code;
//	@ElementCollection
//	@CollectionTable(name="Team", joinColumns = @JoinColumn(name="team_code"))
//	@ManyToOne(cascade = CascadeType.ALL)	
//	private List<Team> teams;

	public Employee(@NotBlank(message = "Name is mandatory") String empl_name,
			@NotBlank(message = "Email is mandatory") String email,
			@NotBlank(message = "Password is mandatory") String password,
			@NotBlank(message = "Gender is mandatory") String gender) {
		super();
		this.empl_name = empl_name;
		this.email = email;
		this.password = password;
		this.gender = gender;
	}

	
	
	
}