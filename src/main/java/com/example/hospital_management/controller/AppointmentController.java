package com.example.hospital_management.controller;

import com.example.hospital_management.model.Appointment;
import com.example.hospital_management.service.AppointmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AppointmentController {
	
    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @GetMapping("hospital/appointment/get")
    public ResponseEntity<List<Appointment>> getAllAppointment(){
        List<Appointment> appointments = appointmentService.findAllAppointments();
        if (appointments.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(appointments);
    }

    @PostMapping("hospital/appointment/add")
    public ResponseEntity<String> addNewAppointment(@RequestBody Appointment appointment){

        try {
            appointmentService.addNewAppointment(appointment);
            return ResponseEntity.status(HttpStatus.CREATED).body("Appointment Added Successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed To Add Details. Check Input And Try Again!");
        }
    }
}
