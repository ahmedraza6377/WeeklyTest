package com.MappingPractice.StudentManagementMappingPractice.Controller;

import com.MappingPractice.StudentManagementMappingPractice.Model.Address;
import com.MappingPractice.StudentManagementMappingPractice.Service.AddService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AddController {
    @Autowired
    AddService addService;

    @PostMapping("Add")
    public Address createAddress(@RequestBody Address address) {
        return addService.createAddress(address);
    }

    @GetMapping("Add/{id}")
    public Address getAddress(@PathVariable Long id) {
        return addService.getAddressById(id);
    }

    @PutMapping("Add/{id}")
    public Address updateAddress(@PathVariable Long id, @RequestBody Address address) {
        return addService.updateAddress(id, address);
    }

    @DeleteMapping("Add/{id}")
    public void deleteAddress(@PathVariable Long id) {
        addService.deleteAddress(id);
    }
}
