package com.example.hospital_management.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hospital_management.model.DoctorDetails;

@Repository
public interface DoctorDetailDao extends JpaRepository<DoctorDetails, Long> {
	
	List<DoctorDetails> findByDepartmentDepartmentId(Long departmentId);
	
}
