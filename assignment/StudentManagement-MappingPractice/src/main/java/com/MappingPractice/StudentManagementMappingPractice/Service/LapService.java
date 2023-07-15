package com.MappingPractice.StudentManagementMappingPractice.Service;

import com.MappingPractice.StudentManagementMappingPractice.Model.Laptop;
import com.MappingPractice.StudentManagementMappingPractice.Repository.ILapRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LapService {
    @Autowired
    private ILapRepo laptopRepository;

    public Laptop createLaptop(Laptop laptop) {
        return laptopRepository.save(laptop);
    }

    public Laptop getLaptopById(Long id) {
        return laptopRepository.findById(id).orElse(null);
    }

    public Laptop updateLaptop(Long id, Laptop updatedLaptop) {
        Laptop existingLaptop = laptopRepository.findById(id).orElse(null);
        if (existingLaptop != null) {
            existingLaptop.setName(updatedLaptop.getName());
            existingLaptop.setBrand(updatedLaptop.getBrand());
            existingLaptop.setPrice(updatedLaptop.getPrice());
            existingLaptop.setStudent(updatedLaptop.getStudent());
            return laptopRepository.save(existingLaptop);
        }
        return null;
    }

    public void deleteLaptop(Long id) {
        laptopRepository.deleteById(id);
    }

}
