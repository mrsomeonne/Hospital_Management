package com.example.hospital_management.controller;

import com.example.hospital_management.model.Department;
import com.example.hospital_management.service.DepartmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("hospital/department/get")
    public List<Department> findAllDepartment(){
        return departmentService.findAllDepartment();
    }

    @PostMapping("hospital/department/add")
    public void addDepartment(@RequestBody Department department){
        departmentService.addDepartment(department);
    }

}
