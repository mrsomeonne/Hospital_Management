package com.example.hospital_management.controller;

import com.example.hospital_management.model.PatientDetails;
import com.example.hospital_management.service.PatientService;
import com.example.hospital_management.serviceImpl.PatientServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hospital/patient")
public class PatientController {

    private final PatientService patientService;
    

    public PatientController(PatientServiceImpl patientService) {
		this.patientService = patientService;
	}

	@GetMapping("/get")
    public ResponseEntity<List<PatientDetails>> getPatientDetails(){
        List<PatientDetails> patientDetails = patientService.getPatientDetails();
        if (patientDetails.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(patientDetails);

    }

    @PostMapping("/add")
    public ResponseEntity<String> savePatient(@RequestBody List<PatientDetails> patientDetails){
        try {
            patientService.addPatientDetail(patientDetails);
            return ResponseEntity.status(HttpStatus.CREATED).body("Patient Details Added Successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed To Add Details. Check Input And Try Again!");
        }
    }
    
    @DeleteMapping("/{patientId}/delete")
    public ResponseEntity<String> deletePatient(@PathVariable Long patientId){
    	try {
    	patientService.deletePatientDetails(patientId);
    	return ResponseEntity.status(HttpStatus.OK).body("Patient Detail Deleted Successfully!");
    	}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Failed To Delete Patient Details!");
		}	
    }

    @GetMapping("/{patientId}/get")
    public ResponseEntity<PatientDetails> getPatientById(@PathVariable Long patientId) {
    	try {
    	PatientDetails getPatient = patientService.getPatientDetailById(patientId);
    	return ResponseEntity.ok(getPatient);
    	}catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
    }
    
    @PutMapping("/{patientId}/update")
    public ResponseEntity<PatientDetails> updatePatientById(@PathVariable Long patientId, @RequestBody PatientDetails patientDetails) {
		try {
    	PatientDetails patientUpadate = patientService.updatePatientDetail(patientId, patientDetails);
    	return ResponseEntity.ok(patientUpadate);
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
    }
    
}
