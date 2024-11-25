package com.example.hospital_management.controller;

import com.example.hospital_management.model.Address;
import com.example.hospital_management.service.AddressService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hospital/patient/address")
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/get")

    public ResponseEntity<List<Address>> getAddress(){
       List<Address> addresses = addressService.getAllAddress();
       if (addresses.isEmpty()){
           return ResponseEntity.notFound().build();
       }
       return ResponseEntity.ok(addresses);
    }

    @PostMapping("/add")
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
    
    @DeleteMapping("/{addressId}/delete")
    public ResponseEntity<String> deleteAddress(@PathVariable Long addressId){
    	try {
    		addressService.deleteAddress(addressId);
    		return ResponseEntity.status(HttpStatus.OK).body("Address Deleted Successfully!");
    	}catch (Exception e) {
    		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Failed To Delete Address!");
    	}
    }
    
    @GetMapping("/{addressId}/get")
    public ResponseEntity<Address> getAddressById(@PathVariable Long addressId){
    	try {
			Address getAddress = addressService.getAddressById(addressId);
			return ResponseEntity.ok(getAddress);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
    }
    
    @PutMapping("{addressId}/update")
    public ResponseEntity<Address> updateAddress(@PathVariable Long addressId, @RequestBody Address address){
    	try {
			Address addressUpdate = addressService.updateAddress(addressId, address);
			return ResponseEntity.ok(addressUpdate);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
    	
    }
    
}
