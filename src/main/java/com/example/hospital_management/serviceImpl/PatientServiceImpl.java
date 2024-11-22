package com.example.hospital_management.serviceImpl;

import com.example.hospital_management.dao.PatientDetailDao;
import com.example.hospital_management.model.PatientDetails;

import com.example.hospital_management.service.PatientService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {



    private final PatientDetailDao patientDetailDao;

    public PatientServiceImpl(PatientDetailDao patientDetailDao) {
        this.patientDetailDao = patientDetailDao;
    }

    @Override
    public List<PatientDetails> getPatientDetails() {

        return patientDetailDao.findAll();
    }

    @Override
    public void addPatientDetail(List<PatientDetails> patientDetails) {
        patientDetailDao.saveAll(patientDetails);
    }

    @Override
    public PatientDetails getPatientDetailById(Long id) {
        return null;
    }

    @Override
    public List<PatientDetails> getPatientDetailByName(String name) {
        return List.of();
    }

    @Override
    public void updatePatientDetail(PatientDetails patientDetails) {

    }

    @Override
    public void deletePatientDetails(Long patientId) {
    	patientDetailDao.deleteById(patientId);
    }
}
