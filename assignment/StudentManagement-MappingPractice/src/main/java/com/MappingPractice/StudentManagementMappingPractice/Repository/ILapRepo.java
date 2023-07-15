package com.MappingPractice.StudentManagementMappingPractice.Repository;

import com.MappingPractice.StudentManagementMappingPractice.Model.Book;
import com.MappingPractice.StudentManagementMappingPractice.Model.Laptop;
import com.MappingPractice.StudentManagementMappingPractice.Service.LapService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILapRepo extends JpaRepository<Laptop,Long> {
}
