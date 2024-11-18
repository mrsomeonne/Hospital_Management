package com.example.hospital_management.controller;

import com.example.hospital_management.model.Department;
import com.example.hospital_management.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Department>> findAllDepartment(){
        List<Department> departments = departmentService.findAllDepartment();
        if (departments.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(departments);
    }

    @PostMapping("hospital/department/add")
    public ResponseEntity<String> addDepartment(@RequestBody Department department){
        try {
            departmentService.addDepartment(department);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body("Department Added Successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed To Add Details. Check Input And Try Again!");
        }
    }

}
