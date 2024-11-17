package com.example.hospital_management.dao;

import com.example.hospital_management.model.PatientDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientDetailDao extends JpaRepository<PatientDetail, Long> {

}
