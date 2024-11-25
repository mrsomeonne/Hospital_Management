package com.example.hospital_management.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.hospital_management.dao.MedicalReportDao;
import com.example.hospital_management.model.MedicalReport;
import com.example.hospital_management.service.MedicalReportService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class MedicalReportServiceImpl implements MedicalReportService{
	
	private final MedicalReportDao medicalReportDao;

	public MedicalReportServiceImpl(MedicalReportDao medicalReportDao) {
		super();
		this.medicalReportDao = medicalReportDao;
	}

	@Override
	public List<MedicalReport> getAllMedicalReport() {
		return medicalReportDao.findAll();
	}

	@Override
	public void addNewMedicalReport(MedicalReport medicalReport) {
		medicalReportDao.save(medicalReport);
	}

	@Override
	public void deleteMedicalReport(Long medicalReportId) {
		MedicalReport exists = medicalReportDao.findById(medicalReportId).orElse(null);
		if (exists == null) {
			throw new EntityNotFoundException()
;		}
		medicalReportDao.deleteById(medicalReportId);
	}

	@Override
	public List<MedicalReport> getReportByPatientId(Long patientId) {
		return medicalReportDao.findByAppointmentPatientDetailsPatientId(patientId);
	}

	@Override
	public MedicalReport getReportById(Long medicalReportId) {
		return medicalReportDao.findById(medicalReportId).get();
	}

	@Override
	public MedicalReport updateMedicalReport(Long medicalReportId, MedicalReport medicalReport) {
		
		MedicalReport exists = medicalReportDao.findById(medicalReportId).orElse(null);
		
		if (exists == null) {
			throw new EntityNotFoundException();
		}
		
		exists.setPrescription(medicalReport.getPrescription());
		exists.setCreatedDate(medicalReport.getCreatedDate());
		exists.setDiagnosis(medicalReport.getDiagnosis());
		exists.setDoctorNotes(medicalReport.getDoctorNotes());
		exists.setAppointment(medicalReport.getAppointment());
		return medicalReportDao.save(exists);
	}
	
}
