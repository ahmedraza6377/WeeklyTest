package com.MappingPractice.StudentManagementMappingPractice.Service;

import com.MappingPractice.StudentManagementMappingPractice.Model.Address;
import com.MappingPractice.StudentManagementMappingPractice.Repository.IAddRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddService {
    @Autowired
    IAddRepo addRepo;

    public Address createAddress(Address address) {
        return addRepo.save(address);
    }

    public Address getAddressById(Long id) {
        return addRepo.findById(id).orElse(null);
    }

    public Address updateAddress(Long id, Address updatedAddress) {
        Address existingAddress = addRepo.findById(id).orElse(null);
        if (existingAddress != null) {
            existingAddress.setLandmark(updatedAddress.getLandmark());
            existingAddress.setZipcode(updatedAddress.getZipcode());
            existingAddress.setDistrict(updatedAddress.getDistrict());
            existingAddress.setState(updatedAddress.getState());
            existingAddress.setCountry(updatedAddress.getCountry());
            return addRepo.save(existingAddress);
        }
        return null;
    }

    public void deleteAddress(Long id) {
        addRepo.deleteById(id);
    }

}
