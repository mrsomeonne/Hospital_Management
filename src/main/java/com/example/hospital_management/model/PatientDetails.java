package com.example.hospital_management.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Date;

@Entity
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter @ToString
public class PatientDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long patientId;
    private String firstName;
    private String lastName;
    @Email	
    private String email;
    private String gender;
    private Date dateOfBirth;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;
}
