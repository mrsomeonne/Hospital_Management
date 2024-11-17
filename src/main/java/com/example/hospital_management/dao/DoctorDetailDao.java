package com.example.hospital_management.dao;

import com.example.hospital_management.model.DoctorDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorDetailDao extends JpaRepository<DoctorDetails, Long> {
}
