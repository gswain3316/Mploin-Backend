package com.example.MPloin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.MPloin.DataModel.Employee;
import com.example.MPloin.DataModel.Seat;
import com.example.MPloin.Repository.EmplRepository;
import com.example.MPloin.Repository.SeatRepository;

@SpringBootApplication
public class MPloinApplication /* implements CommandLineRunner */ {	
	
	
	
	/*
	 * @Autowired SeatRepository seatRepo;
	 * 
	 * List<Seat> SeatList = new ArrayList<Seat>();
	 * 
	 * @Override public void run(String... args) throws Exception { Seat s1 = new
	 * Seat(1, "gswain3316@gmail.com", true, "Tea Break", "Working Fine"); Seat s2 =
	 * new Seat(2, "bibek@gmail.com", true, "Available", "Working Fine"); Seat s3 =
	 * new Seat(3, "akash@gmail.com", false, "Vacation", "Working Fine"); Seat s4 =
	 * new Seat(4, "swaviman@gmail.com", true, "Pee Break", "Working Fine");
	 * 
	 * SeatList.add(s1); SeatList.add(s2); SeatList.add(s3); SeatList.add(s4);
	 * 
	 * seatRepo.insert(SeatList);
	 * 
	 * 
	 * }
	 */
	 

	public static void main(String[] args) {
		SpringApplication.run(MPloinApplication.class, args);
	}

}
