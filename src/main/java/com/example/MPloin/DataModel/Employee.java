package com.example.MPloin.DataModel;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data 
@Document
public class Employee {
	
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
	
	public String getEmpl_name() {
		return empl_name;
	}
	public void setEmpl_name(String empl_name) {
		this.empl_name = empl_name;
	}
	public String getemail() {
		return email;
	}
	public void setemail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}

	/*
	 * public String getCompany() { return company; } public void setCompany(String
	 * company) { this.company = company; } public String getTeam_name() { return
	 * team_name; } public void setTeam_name(String team_name) { this.team_name =
	 * team_name; }
	 */
//	public Long getTeam_code() {
//		return team_code;
//	}
//	public void setTeam_code(Long team_code) {
//		this.team_code = team_code;
//	}
	public String getpassword() {
		return password;
	}
	public void setpassword(String password) {
		this.password = password;
	}
//	public List<Team> getTeams() {
//		return teams;
//	}
//	public void setTeams(List<Team> teams) {
//		teams = teams;
//	}
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
	@Override
	public String toString() {
		return "Employee [empl_name=" + empl_name + ", email=" + email + ", password=" + password
				+ ", gender=" + gender + "]";
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
