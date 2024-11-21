package com.example.hospital_management.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hospital_management.model.MedicalReport;

@Repository
public interface MedicalReportDao extends JpaRepository<MedicalReport, Long> {

}
