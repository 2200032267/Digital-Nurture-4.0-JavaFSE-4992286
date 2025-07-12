package com.cognizant.employeeservice.dao;

import com.cognizant.employeeservice.model.Department;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class DepartmentDao {
    private static List<Department> DEPARTMENT_LIST;

    public DepartmentDao(ApplicationContext context) {
        DEPARTMENT_LIST = Arrays.asList(
            context.getBean("department1", Department.class),
            context.getBean("department2", Department.class)
        );
    }

    public List<Department> getAllDepartments() {
        return DEPARTMENT_LIST;
    }
}
