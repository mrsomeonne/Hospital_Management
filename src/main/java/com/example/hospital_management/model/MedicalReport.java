package com.example.hospital_management.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
public class MedicalReport implements Serializable {

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
