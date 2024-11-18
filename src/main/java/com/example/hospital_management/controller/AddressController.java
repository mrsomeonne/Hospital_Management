package com.example.hospital_management.controller;

import com.example.hospital_management.model.Address;
import com.example.hospital_management.service.AddressService;
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
    public List<Address> getAddress(){
       return addressService.getAllAddress();
    }

    @PostMapping("hospital/patient/address/post")
    public void addAddress(@RequestBody Address address){
        addressService.addAddress(address);
    }

}
