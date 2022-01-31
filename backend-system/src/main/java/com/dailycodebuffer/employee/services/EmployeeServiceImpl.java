package com.dailycodebuffer.employee.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.dailycodebuffer.employee.entity.EmployeeEntity;
import com.dailycodebuffer.employee.model.Employee;
import com.dailycodebuffer.employee.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;

	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Override
	public Employee createEmployee(Employee employee) {
		EmployeeEntity employeeEntity = new EmployeeEntity();

		// copia o conteúdo de uma entidade para outra
		BeanUtils.copyProperties(employee, employeeEntity);
		employeeRepository.save(employeeEntity);
		return employee;
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<EmployeeEntity> employeeEntities = employeeRepository.findAll();
		List<Employee> employees = employeeEntities.stream()
				.map(emp -> new Employee(emp.getId(), emp.getFirstName(), emp.getLastName(), emp.getEmailId()))
				// .map(emp->new Employee(emp)) pode ser usado o contrutor da classe que recebe
				// dados da classe mapeada
				.collect(Collectors.toList());
		return employees;
	}

	@Override
	public boolean deleteEmployee(Long id) {
		// verificar primeiro se existe o employee
		EmployeeEntity employee = employeeRepository.findById(id).get();
		employeeRepository.delete(employee);
		return true;
	}

}
