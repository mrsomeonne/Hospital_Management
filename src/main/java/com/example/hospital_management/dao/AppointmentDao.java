package com.example.hospital_management.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hospital_management.model.Appointment;

@Repository
public interface AppointmentDao extends JpaRepository<Appointment, Long> {
	
	List<Appointment> findByPatientDetailsPatientId(Long patientId);
	
	List<Appointment> findByDoctorDetailsDoctorId(Long doctorId);
	
}
