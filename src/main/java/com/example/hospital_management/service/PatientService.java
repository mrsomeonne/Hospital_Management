package com.example.hospital_management.service;

import com.example.hospital_management.model.PatientDetail;

import java.util.List;


public interface PatientService{

    List<PatientDetail> getPatientDetails();

    void addPatientDetail (PatientDetail patientDetail);

    PatientDetail getPatientDetailById(Long id);

    List<PatientDetail> getPatientDetailByName(String name);

    void updatePatientDetail(PatientDetail patientDetail);

    void deletePatientDetails(PatientDetail patientDetail);


}
