package com.example.hospital_management.dao;

import com.example.hospital_management.model.PatientDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientDetailDao extends JpaRepository<PatientDetails, Long> {

}
