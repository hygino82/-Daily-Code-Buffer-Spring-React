package com.dailycodebuffer.tutorial.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dailycodebuffer.tutorial.entity.Department;
import com.dailycodebuffer.tutorial.error.DepartmentNotFoundException;
import com.dailycodebuffer.tutorial.service.DepartmentService;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;

	private final Logger LOGGER = 
			LoggerFactory.getLogger(DepartmentController.class);

	@PostMapping
	public Department saveDepartment(@Valid @RequestBody Department department) {
		LOGGER.info("Inside saveDepartment on DeparmentController");
		return departmentService.saveDepartment(department);
	}

	@GetMapping
	public List<Department> fetchDepartmentList() {
		LOGGER.info("Inside fetchDepartmentList on DeparmentController");
		return departmentService.fetchDepartmentList();
	}

	@GetMapping("/{id}")
	public Department fetchDepartmentById(@PathVariable("id") Long departmentId) 
			throws DepartmentNotFoundException {
				LOGGER.info("Inside fetchDepartmentById on DeparmentController");
				return departmentService.fetchDepartmentById(departmentId);
	}

	@DeleteMapping("/{id}")
	public void deleteDepartmentById(@PathVariable("id") Long departmentId) {
		LOGGER.info("Inside deleteDepartmentById on DeparmentController");
		departmentService.deleteDepartmentById(departmentId);
	}

	@PutMapping("/{id}")
	public Department updateDepartment(@PathVariable("id") Long departmentId, @RequestBody Department department) {
		LOGGER.info("Inside updateDepartment on DeparmentController");
		return departmentService.updateDepartment(departmentId, department);
	}

	@GetMapping("/name/{name}")
	public Department fetchDepartmentByName(@PathVariable("name") String departmentName) {
		LOGGER.info("Inside fetchDepartmentByName on DeparmentController");
		return departmentService.fetchDepartmentByName(departmentName);
	}
}
