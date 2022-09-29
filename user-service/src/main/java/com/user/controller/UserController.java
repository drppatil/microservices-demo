package com.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/getUser")
	public String getUser() {
		return "Dhiraj Patil";
	}

	@GetMapping("/getdepartment")
	public String getUserDepartment() {
		String result = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/department", String.class);
		return result;
	}

}
