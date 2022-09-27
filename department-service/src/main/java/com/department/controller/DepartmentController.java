package com.department.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
	@GetMapping("/{id}")
	public String findDepartmentById(@PathVariable("id") Long departmentId) {
		return "This is department service";
	}
}
