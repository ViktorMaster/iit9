package com.iit.lab9;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;

@SpringBootApplication
public class Lab9Application {
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(Lab9Application.class);
		app.setDefaultProperties(Collections.singletonMap("server.port", "9091"));
		app.run(args);
	}

}
