package com.geekster.Mappings.service.oneToOne;

import com.geekster.Mappings.model.oneToOne.Address;
import com.geekster.Mappings.model.oneToOne.Employee;
import com.geekster.Mappings.repo.oneToOne.IAddRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    @Autowired
    IAddRepo iAddRepo;


    public void addAddress(Address address) {
        iAddRepo.save(address);
    }

    public Iterable<Address> getAllAddress() {
        return iAddRepo.findAll();
    }

    public Address getAddById(Long id) {
        return iAddRepo.getAddById(id);
    }

    public void deleteAddById(Long id) {
        iAddRepo.deleteById(id);


    }

    public String updateAddById(Long id, Address add) {
        Iterable<Address> itr= iAddRepo.findAll();
        for(Address Add:itr){
            if(Add.getAddId().equals(id)){

                iAddRepo.save(add);
                return "updated";
            }
        }
        return "id not found";
    }


}
