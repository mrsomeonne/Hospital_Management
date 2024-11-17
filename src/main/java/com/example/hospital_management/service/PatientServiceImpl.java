package com.example.hospital_management.service;

import com.example.hospital_management.dao.PatientDetailDao;
import com.example.hospital_management.model.PatientDetail;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PatientServiceImpl implements PatientService{



    private final PatientDetailDao patientDetailDao;

    public PatientServiceImpl(PatientDetailDao patientDetailDao) {
        this.patientDetailDao = patientDetailDao;
    }

    @Override
    public List<PatientDetail> getPatientDetails() {

        return patientDetailDao.findAll();
    }

    @Override
    public void addPatientDetail(PatientDetail patientDetail) {
        patientDetailDao.save(patientDetail);
    }

    @Override
    public PatientDetail getPatientDetailById(Long id) {
        return null;
    }

    @Override
    public List<PatientDetail> getPatientDetailByName(String name) {
        return List.of();
    }

    @Override
    public void updatePatientDetail(PatientDetail patientDetail) {

    }

    @Override
    public void deletePatientDetails(PatientDetail patientDetail) {

    }
}
