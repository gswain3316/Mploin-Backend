package com.example.MPloin.Constants;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@PropertySource("classpath:mploin.properties")
@Data
public class Constants {

	@Value("${FounderName}")
	private String founder;
	@Value("${FoundedOnDate}")
	private Date foundedOn;
	
}
