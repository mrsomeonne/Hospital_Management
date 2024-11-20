package com.example.hospital_management.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Entity
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter @ToString

public class MedicalReport implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 6748061138192602701L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long medicalReportId;
    private String prescription;
    private Date createdDate;
    private String Diagnosis;
    private String doctorNotes;

    @OneToOne
    @JoinColumn(name = "appointmentId")
    private Appointment appointment;



}
