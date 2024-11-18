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
    @NotNull(message = "First Name Is Required!")
    private String firstName;
    @NotNull(message = "Last Name Is Required!")
    private String lastName;
    @Email(message = "Please Enter Valid Email Address!")
    @NotNull(message = "First Name Is Required!")
    private String email;
    @NotNull(message = "Your Gender is Required!")
    private String gender;
    @NotNull(message = "Date Of Birth Is Required!")
    private Date dateOfBirth;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;
}
