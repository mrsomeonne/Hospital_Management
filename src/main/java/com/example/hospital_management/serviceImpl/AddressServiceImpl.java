package com.example.hospital_management.serviceImpl;

import com.example.hospital_management.dao.AddressDao;
import com.example.hospital_management.model.Address;
import com.example.hospital_management.service.AddressService;
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
}
