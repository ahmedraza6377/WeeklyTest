package com.geekster.Mappings.controller.oneToOne;

import com.geekster.Mappings.model.oneToOne.Address;
import com.geekster.Mappings.model.oneToOne.Employee;
import com.geekster.Mappings.service.oneToOne.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AddressController {

    @Autowired
    AddressService addressService;


    @PostMapping("address")
    public void addAddress(@RequestBody Address address)
    {
        addressService.addAddress(address);
    }


    @GetMapping("addresses")
   public Iterable<Address> getAllAddress(){
        return addressService.getAllAddress();
    }
    @GetMapping("address/{id}")
   public Address getAddById(@PathVariable Long id){
        return addressService.getAddById(id);
    }

    // delete a room by id
    @DeleteMapping("address/{id}")
    public String deleteAddById(@PathVariable Long id){
        addressService.deleteAddById(id);
        return "deleted";
    }

    // update room type on the basis of roomId
    @PutMapping("address/{id}")
   public String updateAddById(@PathVariable Long id,@RequestBody Address add){
       return addressService.updateAddById(id,add);


    }
}
