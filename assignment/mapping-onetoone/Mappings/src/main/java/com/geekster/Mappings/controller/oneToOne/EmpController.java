package com.geekster.Mappings.controller.oneToOne;


import com.geekster.Mappings.model.oneToOne.Address;
import com.geekster.Mappings.model.oneToOne.Employee;
import com.geekster.Mappings.service.oneToOne.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class EmpController {

    @Autowired
    EmpService empService;

    @PostMapping("employee")
    public String addEmp(@RequestBody Employee emp)
    {

        empService.addEmp(emp);
        return "added";
    }
    @GetMapping("employees")
    public Iterable<Employee> getEmployees(){
        return empService.getEmployees();
    }



    @GetMapping("employee/{id}")
    public Employee getEmpById(@PathVariable Long id){
        return empService.getEmpById(id);
    }



    // delete a room by id
    @DeleteMapping("employee/{id}")
    public String deleteEmpById(@PathVariable Long id){
        empService.deleteEmpById(id);
        return "deleted";
    }








    // update room type on the basis of roomId
    @PutMapping("employee/{id}")
    public String updateEmployeeByid(@PathVariable Long id,@RequestBody String empName){
        return   empService.updateEmployeeByid(id,empName);

    }

}
