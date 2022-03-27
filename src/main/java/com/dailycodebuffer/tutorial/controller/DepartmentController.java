package com.dailycodebuffer.tutorial.controller;

import java.util.List;

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
import com.dailycodebuffer.tutorial.service.DepartmentService;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;

	@PostMapping
	public Department saveDepartment(@RequestBody Department department) {
		return departmentService.saveDepartment(department);
	}

	@GetMapping
	public List<Department> fetchDepartmentList() {
		return departmentService.fetchDepartmentList();
	}

	@GetMapping("/{id}")
	public Department fetchDepartmentById(@PathVariable("id") Long departmentId) {
		return departmentService.fetchDepartmentById(departmentId);
	}

	@DeleteMapping("/{id}")
	public void deleteDepartmentById(@PathVariable("id") Long departmentId) {
		departmentService.deleteDepartmentById(departmentId);
	}

	@PutMapping("/{id}")
	public Department updateDepartment(@PathVariable("id") Long departmentId, @RequestBody Department department) {
		return departmentService.updateDepartment(departmentId, department);
	}
	
	@GetMapping("/name/{name}")
	public Department fetchDepartmentByName(@PathVariable("name") String departmentName) {
		return departmentService.fetchDepartmentByName(departmentName);
	}
}
