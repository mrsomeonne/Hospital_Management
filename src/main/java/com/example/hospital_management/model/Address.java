package com.example.hospital_management.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter @ToString
public class Address implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 3316991764137178838L;
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressId;
    private String state;
    private String city;
    private Integer zipCode;

}
