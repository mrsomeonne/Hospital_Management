package com.example.hospital_management.serviceImpl;

import com.example.hospital_management.dao.AppointmentDao;
import com.example.hospital_management.model.Appointment;
import com.example.hospital_management.service.AppointmentService;

import jakarta.persistence.EntityNotFoundException;

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

	@Override
	public void deleteAppointment(Long appointmentId) {
		Appointment exists = appointmentDao.findById(appointmentId).orElse(null);
		if (exists == null) {
			throw new EntityNotFoundException();
		}
		appointmentDao.deleteById(appointmentId);
	}

	@Override
	public List<Appointment> findAppointmetByPatientId(Long patientId) {
		return appointmentDao.findByPatientDetailsPatientId(patientId);
	}

	@Override
	public List<Appointment> findAppointmetByDoctorId(Long doctorId) {
		return appointmentDao.findByDoctorDetailsDoctorId(doctorId);
	}

	@Override
	public Appointment getAppointmentById(Long appointmentId) {
		return appointmentDao.findById(appointmentId).get();
	}

	@Override
	public Appointment updateAppointment(Long appointmentId, Appointment appointment) {
		
		Appointment exists = appointmentDao.findById(appointmentId).orElse(null);
		
		if (exists == null) {
			throw new EntityNotFoundException("Appointment With ID: "+appointmentId+" Not Found!");
		}
		
		exists.setAppointmentDate(appointment.getAppointmentDate());
		exists.setStatus(appointment.getStatus());
		exists.setDescription(appointment.getDescription());
		exists.setDoctorDetails(appointment.getDoctorDetails());
		exists.setPatientDetails(appointment.getPatientDetails());
		exists.setMedicalReport(appointment.getMedicalReport());
		
		return appointmentDao.save(exists);
	}
}
