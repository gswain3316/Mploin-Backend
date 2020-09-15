package com.example.MPloin.Entity;

import java.util.List;

import javax.annotation.Generated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.example.MPloin.Utils.CascadeSave;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@Embeddable

@Document
@AllArgsConstructor
@NoArgsConstructor
public @Data class Team {

	@Id
	private ObjectId id;
	@Indexed(unique = true)
	@Field
	private Integer team_code;
//	@OneToMany
//	Employee empl;
//	@NotBlank(message = "Company name is mandatory")
	
	@Field
	private String company;
//	@NotBlank(message = "Team name is mandatory")
	
	@Field
	private String team_name;
//	@NotNull(message = "Team size is mandatory")
	
	@Field
	private Integer size;
	
//	@Column
//	private Long seat_id;
//	@OneToMany(mappedBy = "teams")
//	@Embedded	
	@DBRef(lazy = true)
//	@CascadeSave
	@Field
	private List<Seat> seats;

	public Team(Integer team_code, String company, String team_name, Integer size, List<Seat> seats) {
		super();
		this.team_code = team_code;
		this.company = company;
		this.team_name = team_name;
		this.size = size;
		this.seats = seats;
	}
	 
	
}