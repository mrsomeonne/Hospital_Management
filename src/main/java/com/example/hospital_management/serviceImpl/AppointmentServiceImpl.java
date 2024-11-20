package com.example.hospital_management.serviceImpl;

import com.example.hospital_management.dao.AppointmentDao;
import com.example.hospital_management.model.Appointment;
import com.example.hospital_management.service.AppointmentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentDao appointmentDao;

    public AppointmentServiceImpl(AppointmentDao appointmentDao) {
        this.appointmentDao = appointmentDao;
    }

    @Override
    public List<Appointment> findAllAppointments() {
        return appointmentDao.findAll();
    }

    @Override
    public void addNewAppointment(Appointment appointment) {
        appointmentDao.save(appointment);
    }
}
