package com.example.MPloin.DataModel;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;


//@Entity
@Data
@Document
public class Seat {
	
	@Id
	private ObjectId id;
	// Seat Number has to auto-incremented from back-end.
	/*
	 * @OneToOne Team teams;
	 */
	@Field
    private Integer seat_number;
	
	@Field
    private String email;
	
	@Field
	private Boolean loggedIn;
	
	@Field
	private String status;
	
	public String getemail() {
		return email;
	}
	public void setemail(String email) {
		this.email = email;
	}
	private String machine_status;
	
	public Integer getSeat_number() {
		return seat_number;
	}
	public void setSeat_number(Integer seat_number) {
		this.seat_number = seat_number;
	}
	
	public Boolean getLoggedIn() {
		return loggedIn;
	}
	public void setLoggedIn(Boolean loggedIn) {
		this.loggedIn = loggedIn;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMachine_status() {
		return machine_status;
	}
	public void setMachine_status(String machine_status) {
		this.machine_status = machine_status;
	}
	public Seat(Integer seat_number, String email, Boolean loggedIn, String status,
			String machine_status) {
		super();
		this.seat_number = seat_number;
		this.email = email;
		this.loggedIn = loggedIn;
		this.status = status;
		this.machine_status = machine_status;
	}
	public Seat() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Seat [id=" + id + ", seat_number=" + seat_number + ", email=" + email + ", loggedIn=" + loggedIn
				+ ", status=" + status + ", machine_status=" + machine_status + "]";
	}
	
	
    
}
