package com.example.hospital_management.serviceImpl;

import com.example.hospital_management.dao.DoctorDetailDao;
import com.example.hospital_management.model.DoctorDetails;
import com.example.hospital_management.service.DoctorDetailService;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorDetailServiceImpl implements DoctorDetailService {

    private final DoctorDetailDao doctorDetailDao;

    public DoctorDetailServiceImpl(DoctorDetailDao doctorDetailDao) {
        this.doctorDetailDao = doctorDetailDao;
    }

    @Override
    public List<DoctorDetails> findAllDoctorDetails() {
        return doctorDetailDao.findAll();
    }

    @Override
    public void addDoctorDetails(DoctorDetails doctorDetails) {
        doctorDetailDao.save(doctorDetails);
    }

	@Override
	public void deleteDoctorDetails(Long doctorId) {
		DoctorDetails exists = doctorDetailDao.findById(doctorId).orElse(null);
		if (exists == null) {
			throw new EntityNotFoundException();
		}
		doctorDetailDao.deleteById(doctorId);
	}

	@Override
	public List<DoctorDetails> findDoctorByDepartmentId(Long departmentId) {
		return doctorDetailDao.findByDepartmentDepartmentId(departmentId);
	}

	@Override
	public DoctorDetails findDoctorById(Long doctorId) {
		return doctorDetailDao.findById(doctorId).get();
	}

	@Override
	public DoctorDetails updateDoctorDetails(Long doctorId, DoctorDetails doctorDetails) {
		
		DoctorDetails exists = doctorDetailDao.findById(doctorId).orElse(null);
		
		if (exists == null) {
			throw new EntityNotFoundException("Doctor With ID: "+ doctorId + " Not Found");
		}
		
		exists.setFirstName(doctorDetails.getFirstName());
		exists.setLastName(doctorDetails.getLastName());
		exists.setEmail(doctorDetails.getEmail());
		exists.setPhoneNumber(doctorDetails.getPhoneNumber());
		exists.setSpecialization(doctorDetails.getSpecialization());
		exists.setQualification(doctorDetails.getQualification());
		exists.setDepartment(doctorDetails.getDepartment());
		exists.setAppointments(doctorDetails.getAppointments());

		return doctorDetailDao.save(exists);
		
	}
}
