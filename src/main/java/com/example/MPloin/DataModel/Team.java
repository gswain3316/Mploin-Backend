package com.example.MPloin.DataModel;

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

import lombok.Data;

//@Embeddable
@Data
@Document
public class Team {

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
	 

	public Integer getTeam_code() {
		return team_code;
	}

	public void setTeam_code(Integer team_code) {
		this.team_code = team_code;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getTeam_name() {
		return team_name;
	}

	public void setTeam_name(String team_name) {
		this.team_name = team_name;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

//	public Long getSeat_id() {
//		return seat_id;
//	}
//	public void setSeat_id(Long seat_id) {
//		this.seat_id = seat_id;
//	}
	public List<Seat> getSeats() {
		return seats;
	}

	public void setSeats(List<Seat> seats) {
		this.seats = seats;
	}

	public Team(Integer team_code, @NotBlank(message = "Company name is mandatory") String company,
			@NotBlank(message = "Team name is mandatory") String team_name,
			@NotNull(message = "Team size is mandatory") Integer size, List<Seat> seats) {
		super();
		this.team_code = team_code;
		this.company = company;
		this.team_name = team_name;
		this.size = size;
		this.seats = seats;
	}

	public Team() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Team [id=" + id + ", team_code=" + team_code + ", company=" + company + ", team_name=" + team_name
				+ ", size=" + size + ", seats=" + seats + "]";
	}

	
	
}