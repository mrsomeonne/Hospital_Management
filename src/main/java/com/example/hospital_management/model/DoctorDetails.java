package com.example.hospital_management.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter @ToString
public class DoctorDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long doctorId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String qualification;
    private String specialization;

    @ManyToOne
    @JoinColumn(name = "departmentId")
    @JsonBackReference
    private Department department;



}
