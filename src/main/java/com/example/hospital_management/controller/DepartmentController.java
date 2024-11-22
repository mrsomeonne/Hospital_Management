package com.example.hospital_management.controller;

import com.example.hospital_management.model.Department;
import com.example.hospital_management.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hospital/department")
public class DepartmentController {

	private final DepartmentService departmentService;

	public DepartmentController(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	@GetMapping("/get")
	public ResponseEntity<List<Department>> findAllDepartment() {
		List<Department> departments = departmentService.findAllDepartment();
		if (departments.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(departments);
	}

	@PostMapping("/add")
	public ResponseEntity<String> addDepartment(@RequestBody Department department) {
		try {
			departmentService.addDepartment(department);
			return ResponseEntity.status(HttpStatus.CREATED).body("Department Added Successfully!");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Failed To Add Details. Check Input And Try Again!");
		}
	}
	
	@DeleteMapping("/{departmentId}/delete")
	public ResponseEntity<String> deleteDepartment(@PathVariable Long departmentId) {
		try {
			departmentService.deleteDepartment(departmentId);
			return ResponseEntity.status(HttpStatus.OK).body("Department Deleted Successfully");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Failed To Delete Department!");
		}
	}

}
