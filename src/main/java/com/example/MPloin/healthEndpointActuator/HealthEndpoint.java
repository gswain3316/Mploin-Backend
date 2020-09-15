package com.example.MPloin.healthEndpointActuator;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

@Component
public class HealthEndpoint implements HealthIndicator {

	@Override
	public Health health() {
		boolean valid = Runtime.getRuntime().maxMemory() > (100*1024*1024);
		Status status = valid ? Status.UP : Status.DOWN;
		return Health.status(status).build();
	}

	
	
}
