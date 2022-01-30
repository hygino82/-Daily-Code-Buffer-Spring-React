package com.dailycodebuffer.employee.services;

import java.util.List;

import com.dailycodebuffer.employee.model.Employee;

public interface EmployeeService {

	Employee createEmployee(Employee employee);

	List<Employee> getAllEmployees();

}
