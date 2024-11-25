package com.example.hospital_management.serviceImpl;

import com.example.hospital_management.dao.AddressDao;
import com.example.hospital_management.model.Address;
import com.example.hospital_management.service.AddressService;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    private final AddressDao addressDao;

    public AddressServiceImpl(AddressDao addressDao) {
        this.addressDao = addressDao;
    }

    @Override
    public List<Address> getAllAddress() {
        return addressDao.findAll();
    }

    @Override
    public void addAddress(Address address) {
        addressDao.save(address);
    }

	@Override
	public void deleteAddress(Long addressId) {
		addressDao.deleteById(addressId);
	}

	@Override
	public Address getAddressById(Long addressId) {
		return addressDao.findById(addressId).get();
	}

	@Override
	public Address updateAddress(Long addressId, Address address) {
	
		Address exists = addressDao.findById(addressId).orElse(null);
		
		if (exists == null) {
			throw new EntityNotFoundException();
		}
		
		exists.setCity(address.getCity());
		exists.setState(address.getState());
		exists.setZipCode(address.getZipCode());
		
		return addressDao.save(exists);
	}
	
	
}
