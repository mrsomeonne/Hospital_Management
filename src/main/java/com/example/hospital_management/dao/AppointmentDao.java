package com.example.hospital_management.dao;

import com.example.hospital_management.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentDao extends JpaRepository<Appointment, Long> {
}