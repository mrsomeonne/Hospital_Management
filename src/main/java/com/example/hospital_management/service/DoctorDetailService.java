package com.example.hospital_management.service;

import com.example.hospital_management.model.DoctorDetails;

import java.util.List;

public interface DoctorDetailService {

    List<DoctorDetails> findAllDoctorDetails();

    void addDoctorDetails(DoctorDetails doctorDetails);

    void deleteDoctorDetails(Long doctorId);
    
    List<DoctorDetails> findDoctorByDepartmentId(Long departmentId);
    
    DoctorDetails findDoctorById(Long doctorId);
    
    DoctorDetails updateDoctorDetails(Long doctorId, DoctorDetails doctorDetails);

}
