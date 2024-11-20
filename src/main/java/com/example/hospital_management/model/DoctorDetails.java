package com.example.hospital_management.model;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter @ToString
public class DoctorDetails implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long doctorId;
    private String firstName;
    private String lastName;
    @Email
    private String email;
    private String phoneNumber;
    private String qualification;
    private String specialization;

    @ManyToOne
    @JoinColumn(name = "departmentId", nullable = false)
    @JsonBackReference
    private Department department;

    @JsonIgnore
    @OneToMany(mappedBy = "doctorDetails", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Appointment> appointments;

}
