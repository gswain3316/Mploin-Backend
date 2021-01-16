package com.example.MPloin.Constants;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@ConfigurationProperties("app")
@Data
public class SwaggerURL {

	private String SwaggerURL;
	
}
