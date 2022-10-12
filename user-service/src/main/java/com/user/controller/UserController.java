package com.user.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private RestTemplate restTemplate;
	private static final String SERVICE_NAME = "userService";
	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	@GetMapping("/getUser")
	public String getUser() {
		return "Dhiraj Patil";
	}

	@GetMapping("/getdepartment")
	@CircuitBreaker(name = SERVICE_NAME, fallbackMethod = "userServiceFallback")
	public String getUserDepartment() {
		LOG.info("Calling Department service from User service");
		String result = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/department", String.class);
		return result;
	}

	
	
	public String userServiceFallback(Exception e) {
		return "Department service is down.";

	}

}
