package com.MappingPractice.StudentManagementMappingPractice.Repository;

import com.MappingPractice.StudentManagementMappingPractice.Model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAddRepo extends JpaRepository<Address,Long> {
}
