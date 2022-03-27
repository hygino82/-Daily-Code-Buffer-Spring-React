package com.dailycodebuffer.tutorial.service;

import com.dailycodebuffer.tutorial.entity.Department;
import com.dailycodebuffer.tutorial.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;

    @MockBean
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {
        Department department = Department.builder()
                .departmentName("Limpeza")
                .departmentAddress("Linha borges")
                .departmentCode("exaq52")
                .departmentId(1L)
                .build();

        Mockito.when(departmentRepository.findBydepartmentNameIgnoreCase("Limpeza"))
                .thenReturn(department);
    }

    @Test
    @DisplayName("Get Data based on Valid Department")
    //@Disabled
    public void whenValidDepartmentName_thenDepartmentShouldFound() {
        String departmentName = "Limpeza";
        Department found = departmentService.fetchDepartmentByName(departmentName);

        assertEquals(departmentName, found.getDepartmentName());
    }
}