package com.example.hospital_management.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.hospital_management.model.MedicalReport;
import com.example.hospital_management.service.MedicalReportService;

@Controller
public class MedicalReportController {
	
	private final MedicalReportService medicalReportService;

	public MedicalReportController(MedicalReportService medicalReportService) {
		super();
		this.medicalReportService = medicalReportService;
	}
	
	@GetMapping("hospital/report/get")
	public ResponseEntity<List<MedicalReport>> getAllMediacalReport(){
		
		List<MedicalReport> medicalReport = medicalReportService.getAllMedicalReport();
		if(medicalReport.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(medicalReport); 
	}
	
	@PostMapping("hospital/report/add")
	public ResponseEntity<String> addNewMedicalReport(@RequestBody MedicalReport medicalReport){
		try {
			medicalReportService.addNewMedicalReport(medicalReport);
			return ResponseEntity.status(HttpStatus.CREATED).body("Medical Report Added Successfully!");
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Failed To Add Details. Check Input And Try Again!");
		}
	}

}
