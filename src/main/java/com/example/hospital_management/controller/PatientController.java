package com.example.hospital_management.controller;

import com.example.hospital_management.model.PatientDetails;
import com.example.hospital_management.service.PatientServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PatientController {

//    private PatientDetail patientDetail;

    private final PatientServiceImpl patientService;

    @GetMapping("hospital/patient/get")
    public List<PatientDetails> getPatientDetails(){
        return patientService.getPatientDetails();
    }

    @PostMapping("hospital/patient/add")
    public ResponseEntity<String> savePatient(@RequestBody PatientDetails patientDetails){
        patientService.addPatientDetail(patientDetails);
        System.out.println(patientDetails);
       return new ResponseEntity<>("Patient Added Successfully!", HttpStatus.OK);
    }
}
