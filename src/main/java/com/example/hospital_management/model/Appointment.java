package com.example.hospital_management.model;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter @ToString
public class Appointment implements Serializable {

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
