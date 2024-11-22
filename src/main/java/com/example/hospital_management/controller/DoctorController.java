package com.example.hospital_management.controller;

import com.example.hospital_management.model.DoctorDetails;
import com.example.hospital_management.service.DoctorDetailService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hospital/doctor")
public class DoctorController {

    private final DoctorDetailService doctorService;

    public DoctorController(DoctorDetailService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping("/get")
    public ResponseEntity<List<DoctorDetails>> findDoctorDetail(){
        List<DoctorDetails> doctorDetails = doctorService.findAllDoctorDetails();
        if (doctorDetails.isEmpty()){
           return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(doctorDetails);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addDoctorDetail(@RequestBody DoctorDetails doctorDetails){

        try {
            doctorService.addDoctorDetails(doctorDetails);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body("Doctor Details Added Successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed To Add Details. Check Input And Try Again!");
        }
    }
    
    @DeleteMapping("/{doctorId}/delete")
    public ResponseEntity<String> deleteDoctorDetails(@PathVariable Long doctorId){
    	try {
    		doctorService.deleteDoctorDetails(doctorId);
    		return ResponseEntity.status(HttpStatus.OK).body("Doctor Details Deleted Successfully!");
    	}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Failed To Add Details. Check Input And Try Again!");
    	}
    }

    // TODO: Get Doctor By Department
    
}
