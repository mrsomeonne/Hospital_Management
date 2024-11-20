package com.example.hospital_management.controller;

import com.example.hospital_management.model.PatientDetails;
import com.example.hospital_management.service.PatientService;
import com.example.hospital_management.serviceImpl.PatientServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PatientController {

    private final PatientService patientService;
    

    public PatientController(PatientServiceImpl patientService) {
		super();
		this.patientService = patientService;
	}

	@GetMapping("hospital/patient/get")
    public ResponseEntity<List<PatientDetails>> getPatientDetails(){
        List<PatientDetails> patientDetails = patientService.getPatientDetails();
        if (patientDetails.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(patientDetails);

    }

    @PostMapping("hospital/patient/add")
    public ResponseEntity<String> savePatient(@RequestBody PatientDetails patientDetails){
        try {
            patientService.addPatientDetail(patientDetails);
            return ResponseEntity.status(HttpStatus.CREATED).body("Patient Details Added Successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed To Add Details. Check Input And Try Again!");
        }
    }
}
