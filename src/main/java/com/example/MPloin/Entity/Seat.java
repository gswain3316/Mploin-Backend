package com.example.MPloin.Entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;


//@Entity

@Document
@AllArgsConstructor
@RequiredArgsConstructor
public @Data class Seat {
	
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
	
	@Field
	private String machine_status;

	public Seat(Integer seat_number, String email, Boolean loggedIn, String status, String machine_status) {
		super();
		this.seat_number = seat_number;
		this.email = email;
		this.loggedIn = loggedIn;
		this.status = status;
		this.machine_status = machine_status;
	}

	
	
    
}
