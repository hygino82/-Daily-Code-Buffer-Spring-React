package com.dailycodebuffer.tutorial.service;

import java.util.List;

import com.dailycodebuffer.tutorial.entity.Department;
import com.dailycodebuffer.tutorial.error.DepartmentNotFoundException;

public interface DepartmentService {

    Department saveDepartment(Department department);

    List<Department> fetchDepartmentList();

    Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException;

    void deleteDepartmentById(Long departmentId);

    Department updateDepartment(Long departmentId, Department department);

    Department fetchDepartmentByName(String departmentName);

}
