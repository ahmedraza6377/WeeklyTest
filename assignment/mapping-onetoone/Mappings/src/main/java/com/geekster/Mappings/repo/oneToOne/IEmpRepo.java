package com.geekster.Mappings.repo.oneToOne;

import com.geekster.Mappings.model.oneToOne.Address;
import com.geekster.Mappings.model.oneToOne.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmpRepo extends CrudRepository<Employee,Long> {



    @Query(value = "select * from employee where emp_id = :id" , nativeQuery = true)
    Employee findEmpById(Long id);
}
