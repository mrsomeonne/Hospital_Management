package com.example.hospital_management.service;

import java.util.List;

import com.example.hospital_management.model.MedicalReport;

public interface MedicalReportService {
	
	List<MedicalReport> getAllMedicalReport();
	
	void addNewMedicalReport(MedicalReport medicalReport);
	
}
