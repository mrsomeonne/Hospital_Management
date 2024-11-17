package com.example.hospital_management.service;

import com.example.hospital_management.dao.DoctorDetailDao;
import com.example.hospital_management.model.DoctorDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorDetailServiceImpl implements DoctorDetailService{

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
}
