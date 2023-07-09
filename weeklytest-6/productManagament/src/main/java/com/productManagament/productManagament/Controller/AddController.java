package com.productManagament.productManagament.Controller;

import com.productManagament.productManagament.Model.Address;
import com.productManagament.productManagament.Service.AddService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddController {
    @Autowired
    AddService addService;

    @PostMapping("address")
    public Address createAddress(@RequestBody Address address) {
        return addService.createAddress(address);
    }
}
