package com.geekster.Mappings.service.oneToOne;

import com.geekster.Mappings.model.oneToOne.Address;
import com.geekster.Mappings.model.oneToOne.Employee;
import com.geekster.Mappings.repo.oneToOne.IEmpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmpService {

    @Autowired
    IEmpRepo iEmpRepo;

    public void addEmp(Employee emp) {
        iEmpRepo.save(emp);
    }

    public Iterable<Employee> getEmployees() {
        return iEmpRepo.findAll();
    }


    public Employee getEmpById(Long id) {
        return iEmpRepo.findEmpById(id);
    }

    public void deleteEmpById(Long id) {
        iEmpRepo.deleteById(id);
    }

    public String updateEmployeeByid(Long id, String empName) {
        Iterable<Employee> itr= iEmpRepo.findAll();
        for(Employee emp:itr){
            if(emp.getEmpId().equals(id)){
                emp.setEmpName(empName);
                iEmpRepo.save(emp);
                return "updated";
            }
        }
    return "id not found";

    }
}
