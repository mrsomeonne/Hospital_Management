package com.example.hospital_management.service;

import com.example.hospital_management.model.PatientDetails;

import java.util.List;


public interface PatientService{

    List<PatientDetails> getPatientDetails();

    void addPatientDetail (List<PatientDetails> patientDetails);

    PatientDetails getPatientDetailById(Long patientId);

    PatientDetails updatePatientDetail(Long paitentId, PatientDetails patientDetails);

    void deletePatientDetails(Long patientId);

}
