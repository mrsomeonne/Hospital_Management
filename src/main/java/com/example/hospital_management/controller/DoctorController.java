package com.example.hospital_management.controller;

import com.example.hospital_management.model.DoctorDetails;
import com.example.hospital_management.service.DoctorDetailService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DoctorController {

    private final DoctorDetailService doctorService;

    public DoctorController(DoctorDetailService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping("hospital/doctor/get")
    public List<DoctorDetails> findDoctorDetail(){
        return doctorService.findAllDoctorDetails();
    }

    @PostMapping("hospital/doctor/add")
    public void addDoctorDetail(@RequestBody DoctorDetails doctorDetails){
        doctorService.addDoctorDetails(doctorDetails);
    }

}
