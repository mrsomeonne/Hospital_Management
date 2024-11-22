package com.example.hospital_management.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hospital_management.model.Appointment;
import com.example.hospital_management.service.AppointmentService;

@RestController
@RequestMapping("/hospital/appointment")
public class AppointmentController {

	private final AppointmentService appointmentService;

	public AppointmentController(AppointmentService appointmentService) {
		this.appointmentService = appointmentService;
	}

	@GetMapping("/get")
	public ResponseEntity<List<Appointment>> getAllAppointment() {
		List<Appointment> appointments = appointmentService.findAllAppointments();
		if (appointments.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(appointments);
	}

	@PostMapping("/add")
	public ResponseEntity<String> addNewAppointment(@RequestBody Appointment appointment) {

		try {
			appointmentService.addNewAppointment(appointment);
			return ResponseEntity.status(HttpStatus.CREATED).body("Appointment Added Successfully!");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Failed To Add Details. Check Input And Try Again!");
		}
	}

	@DeleteMapping("/{appointmentId}/delete")
	public ResponseEntity<String> deleteAppointment(@PathVariable Long appointmentId) {
		try {
			appointmentService.deleteAppointment(appointmentId);
			return ResponseEntity.status(HttpStatus.OK).body("Appointment Deleted Successfully!");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Failed To Delete Appointment!");
		}
	}

	// TODO: Get Appointment By Patient
	// :Get Appointment By Doctor

}
