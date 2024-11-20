package com.example.hospital_management.model;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter @ToString
public class Appointment implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 2026364769631651838L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long appointmentId;
    private Date appointmentDate;
    private boolean status;
    private String description;

    @ManyToOne
    @JoinColumn(name = "patientId", nullable = false)
    private PatientDetails patientDetails;

    @ManyToOne
    @JoinColumn(name = "doctorId", nullable = false)
    private DoctorDetails doctorDetails;

//    @OneToOne(mappedBy = "appointment", cascade = CascadeType.ALL)
//    private MedicalReport medicalReport;






}
