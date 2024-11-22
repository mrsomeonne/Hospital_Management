package com.example.hospital_management.serviceImpl;

import com.example.hospital_management.dao.DoctorDetailDao;
import com.example.hospital_management.model.DoctorDetails;
import com.example.hospital_management.service.DoctorDetailService;
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
		doctorDetailDao.deleteById(doctorId);
	}

	@Override
	public List<DoctorDetails> findDoctorByDepartmentId(Long departmentId) {
		return doctorDetailDao.findByDepartmentDepartmentId(departmentId);
	}
}
