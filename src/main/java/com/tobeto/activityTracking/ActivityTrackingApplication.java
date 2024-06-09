package com.tobeto.activityTracking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.modelmapper.ModelMapper;

@SpringBootApplication
public class ActivityTrackingApplication {

	public static void main(String[] args) {
		SpringApplication.run(ActivityTrackingApplication.class, args);
	}

	@Bean
	public ModelMapper getModelMapper(){ return new ModelMapper();}

}
