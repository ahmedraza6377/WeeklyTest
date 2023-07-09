package com.productManagament.productManagament.Service;

import com.productManagament.productManagament.Model.Address;
import com.productManagament.productManagament.Repository.IAddRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddService {
    @Autowired
    IAddRepo addRepo;

    public Address createAddress(Address address) {
        return addRepo.save(address);
    }
}
