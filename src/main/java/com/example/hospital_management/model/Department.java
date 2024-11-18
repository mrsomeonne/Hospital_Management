package com.example.hospital_management.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter @ToString
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long departmentId;
    private String name;
    private String description;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<DoctorDetails> doctorDetails = new ArrayList<>();
}
