package com.example.hospital_management.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.hospital_management.dao.MedicalReportDao;
import com.example.hospital_management.model.MedicalReport;
import com.example.hospital_management.service.MedicalReportService;

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
		medicalReportDao.deleteById(medicalReportId);
	}
	
}
