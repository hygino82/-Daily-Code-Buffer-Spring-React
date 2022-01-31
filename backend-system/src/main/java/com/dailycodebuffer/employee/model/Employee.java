package com.dailycodebuffer.employee.model;

import com.dailycodebuffer.employee.entity.EmployeeEntity;

//import com.dailycodebuffer.employee.entity.EmployeeEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

	private long id;
	private String firstName;
	private String lastName;
	private String emailId;

	public Employee(EmployeeEntity emp) {
		//criado para facilitar passar os dados de EmployeeEntity para Employee
		id = emp.getId();
		firstName = emp.getFirstName();
		lastName = emp.getLastName();
		emailId = emp.getEmailId();
	}
}
