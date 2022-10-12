package com.department.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/departments")
public class DepartmentController {

	@Value("${server.port}")
	private int serverPort;
	private static final String SERVICE_NAME = "departmentService";
	private final Logger LOG = LoggerFactory.getLogger(this.getClass());

	@GetMapping("/{id}")
	public String findDepartmentById(@PathVariable("id") Long departmentId) {
		return "This is department service";
	}

	@GetMapping("/department")
	public String getUserDeparment() {
		LOG.info("Call into department service");
		return "This is department service using eureka " + serverPort;
	}

	
}
