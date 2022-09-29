package com.department.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

	@Value("${server.port}")
	private int serverPort;
	private static final String SERVICE_NAME = "departmentService";

	@GetMapping("/{id}")
	public String findDepartmentById(@PathVariable("id") Long departmentId) {
		return "This is department service";
	}

	@CircuitBreaker(name=SERVICE_NAME,fallbackMethod="departmentServiceFallback")
	@GetMapping("/department")
	public String getUserDeparment() {
		return "This is department service using eureka " + serverPort;
	}
	
	public String departmentServiceFallback(Exception e) {
		return "Department service is down.";
		
	}
}
