package com.MappingPractice.StudentManagementMappingPractice.Controller;

import com.MappingPractice.StudentManagementMappingPractice.Model.Laptop;
import com.MappingPractice.StudentManagementMappingPractice.Service.LapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class LapController {

    @Autowired
    private LapService laptopService;

    @PostMapping("lap")
    public Laptop createLaptop(@RequestBody Laptop laptop) {
        return laptopService.createLaptop(laptop);
    }

    @GetMapping("lap/{id}")
    public Laptop getLaptop(@PathVariable Long id) {
        return laptopService.getLaptopById(id);
    }

    @PutMapping("lap/{id}")
    public Laptop updateLaptop(@PathVariable Long id, @RequestBody Laptop laptop) {
        return laptopService.updateLaptop(id, laptop);
    }

    @DeleteMapping("lap/{id}")
    public void deleteLaptop(@PathVariable Long id) {
        laptopService.deleteLaptop(id);
    }

}
