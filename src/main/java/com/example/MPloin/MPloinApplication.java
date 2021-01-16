package com.example.MPloin;

import java.util.ArrayList;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import com.example.MPloin.Constants.Constants;
import com.example.MPloin.Constants.SwaggerURL;
import com.example.MPloin.Dto.LoginDto;
import com.example.MPloin.Entity.Seat;
import com.example.MPloin.Repository.EmplRepository;
import com.example.MPloin.Repository.SeatRepository;
import com.example.MPloin.Entity.Employee;

import io.swagger.models.License;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

@EnableSwagger2WebMvc
@SpringBootApplication()
@Import(SpringDataRestConfiguration.class)
public class MPloinApplication implements CommandLineRunner  {	
	
	private static Logger logger = LoggerFactory.getLogger(MPloinApplication.class);
	
	@Autowired
	private Constants constant;
	
	@Autowired
	private SwaggerURL swagger;
	
	@Autowired
	private LoginDto loginDto;
	
	@Bean
	public Docket MploinApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.any())
				.build()
				.apiInfo(getApiInfo());
	}

	private ApiInfo getApiInfo() {
		return new ApiInfoBuilder()
				.title("Mploin Application API")
				.version("1.0.0")
				.description("Office Application for Employees")
				.contact(new Contact("Gaurav Swain", "http://linkedin.com/in/gauravswain", "gswain3316@gmail.com"))
				.license("Apache License Version 2.0")
				.build();
	}

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

	@Override
	public void run(String... args) throws Exception {
		
		logger.info(constant.getFounder());
		logger.info(swagger.getSwaggerURL());
		
	}

}
