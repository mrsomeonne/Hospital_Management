package com.example.hospital_management.service;

import com.example.hospital_management.model.Appointment;

import java.util.List;

public interface AppointmentService {

    List<Appointment> findAllAppointments();

    void addNewAppointment(Appointment appointment);

    void deleteAppointment(Long appointmentId);

}
