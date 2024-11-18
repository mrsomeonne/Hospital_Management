package com.example.hospital_management.service;

import com.example.hospital_management.model.PatientDetails;

import java.util.List;


public interface PatientService{

    List<PatientDetails> getPatientDetails();

    void addPatientDetail (PatientDetails patientDetails);

    PatientDetails getPatientDetailById(Long id);

    List<PatientDetails> getPatientDetailByName(String name);

    void updatePatientDetail(PatientDetails patientDetails);

    void deletePatientDetails(PatientDetails patientDetails);


}
