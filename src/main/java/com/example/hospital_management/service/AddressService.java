package com.example.hospital_management.service;

import com.example.hospital_management.model.Address;

import java.util.List;

public interface AddressService {

    List<Address> getAllAddress();

    void addAddress(Address address);
    
    void deleteAddress(Long addressId);

}
