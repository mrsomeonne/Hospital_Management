package com.example.hospital_management.controller;

import com.example.hospital_management.model.Address;
import com.example.hospital_management.service.AddressService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("Hospital/patient/address/get")

    public ResponseEntity<List<Address>> getAddress(){
       List<Address> addresses = addressService.getAllAddress();
       if (addresses.isEmpty()){
           return ResponseEntity.notFound().build();
       }
       return ResponseEntity.ok(addresses);
    }

    @PostMapping("hospital/patient/address/post")
    public ResponseEntity<String> addAddress(@RequestBody Address address){

        try {
            addressService.addAddress(address);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body("Address Added Successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed To Add Details. Check Input And Try Again!");
        }
    }

}
