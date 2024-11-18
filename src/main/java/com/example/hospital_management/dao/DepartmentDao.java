package com.example.hospital_management.dao;

import com.example.hospital_management.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentDao extends JpaRepository<Department, Long> {
}
