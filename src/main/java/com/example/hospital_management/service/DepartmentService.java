package com.example.hospital_management.service;

import com.example.hospital_management.model.Department;

import java.util.List;

public interface DepartmentService {

    List<Department> findAllDepartment();

    void addDepartment(Department department);

}
