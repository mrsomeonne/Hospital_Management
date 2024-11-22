package com.example.hospital_management.service;

import com.example.hospital_management.model.Department;

import java.util.List;

public interface DepartmentService {

    List<Department> findAllDepartment();

    void addDepartment(List<Department> department);
    
    void deleteDepartment(Long departmentId);

}
