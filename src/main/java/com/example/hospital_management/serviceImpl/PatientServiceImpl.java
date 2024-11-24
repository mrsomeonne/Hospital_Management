package com.example.hospital_management.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.hospital_management.dao.PatientDetailDao;
import com.example.hospital_management.model.PatientDetails;
import com.example.hospital_management.service.PatientService;

import jakarta.persistence.EntityNotFoundException;

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
    public PatientDetails getPatientDetailById(Long patientId) {
        return patientDetailDao.findById(patientId).get();
    }


    @Override
    public PatientDetails updatePatientDetail(Long patientId, PatientDetails patientDetails) {
    	
    	PatientDetails exists = patientDetailDao.findById(patientId)
    			.orElse(null);
    	
    	if (exists == null) {
    		throw new EntityNotFoundException("Patient With Id: "+ patientId + " Not Found!");
    	}
    	
    	exists.setFirstName(patientDetails.getFirstName());
    	exists.setLastName(patientDetails.getLastName());
    	exists.setEmail(patientDetails.getEmail());
    	exists.setGender(patientDetails.getGender());
    	exists.setDateOfBirth(patientDetails.getDateOfBirth());
    	exists.setAddress(patientDetails.getAddress());
    	//exists.setAppointments(patientDetails.getAppointments());
    	
    	return patientDetailDao.save(exists);
    }

    @Override
    public void deletePatientDetails(Long patientId) {
    	patientDetailDao.deleteById(patientId);
    }
}
