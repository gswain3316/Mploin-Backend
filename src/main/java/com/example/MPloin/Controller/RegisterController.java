package com.example.MPloin.Controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.MPloin.Entity.Employee;
import com.example.MPloin.Entity.Seat;
import com.example.MPloin.Entity.Team;
import com.example.MPloin.Repository.EmplRepository;
import com.example.MPloin.Repository.SeatRepository;
import com.example.MPloin.Repository.TeamRepository;
import com.example.MPloin.Service.RegistrationService;

@RestController
public class RegisterController {

	@Autowired
	private EmplRepository empRepo;

	@Autowired
	private TeamRepository teamRepo;

	@Autowired
	private SeatRepository seatRepo;

	@Autowired
	private RegistrationService registerServ;

	@GetMapping("/test")
	public String test() {
		List<Seat> seatList = new ArrayList<Seat>();
		seatList = seatRepo.findAll();

		seatList.add(new Seat(5, "jeff@gmail.com", true, "Tea Break", "Working Fine"));
		seatList.add(new Seat(6, "elon@gmail.com", true, "Available", "Working Fine"));
		seatList.add(new Seat(7, "bill@gmail.com", false, "Vacation", "Working Fine"));
		seatList.add(new Seat(8, "mark@gmail.com", true, "Pee Break", "Working Fine"));
		
		seatRepo.insert(seatList);

		
		teamRepo.insert(new Team(005, "Mploin", "CoFounders", 4, seatList));
		return "team document created multiple seat documents !!";
		 
	}

	@GetMapping("/joinTeam")
	public ResponseEntity<Object> joinTeam(@Valid @RequestParam Long team_code) {
		return registerServ.joinTeam(team_code);
	}

	@PostMapping("/registerEmployee")
	public ResponseEntity<Object> registeremployee(@Valid @RequestBody Employee empl) throws Exception {
		Employee emp = empRepo.save(empl);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{empl_email}")
				.buildAndExpand(emp.getEmail()).toUri();
//		return "Registration is completed successfully !!";
		return ResponseEntity.created(location).build();
	}

	@PostMapping("/registerTeam")
	public ResponseEntity<Object> registerTeam(@Valid @RequestBody Team team) throws Exception {
		Team new_team = teamRepo.save(team);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{team_code}")
				.buildAndExpand(new_team.getTeam_code()).toUri();
		return ResponseEntity.created(location).build();
	}

	@PutMapping("/registerPassword")
	public String registerPassword(@Valid @RequestParam String empl_email, @RequestParam String empl_password)
			throws Exception {
		ResponseEntity<Object> result = registerServ.registerPassword(empl_email, empl_password);
		if (result.getStatusCode() == HttpStatus.OK)
			return "Password successfully saved !!";
		else
			return "Error, Password not saved. TRY AGAIN !!";
	}

	@GetMapping("/findEmployeeByExample")
	public List<Employee> getEmployeeByExample(@Valid @RequestBody Employee emp) {
		return registerServ.getEmployeeByEx(emp);
	}

}
