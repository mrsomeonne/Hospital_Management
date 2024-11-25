package com.example.hospital_management.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter @ToString
public class DoctorDetails implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 2120433985130703034L;
	
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
    @OneToMany(mappedBy = "doctorDetails", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Appointment> appointments;

}
