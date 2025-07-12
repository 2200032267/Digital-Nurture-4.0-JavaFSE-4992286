package com.cognizant.employeeservice.service;

import com.cognizant.employeeservice.dao.DepartmentDao;
import com.cognizant.employeeservice.model.Department;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    private final DepartmentDao departmentDao;

    public DepartmentService(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }

    public List<Department> getAllDepartments() {
        return departmentDao.getAllDepartments();
    }
}
