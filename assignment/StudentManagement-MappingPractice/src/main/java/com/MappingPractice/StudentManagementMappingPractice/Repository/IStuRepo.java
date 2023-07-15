package com.MappingPractice.StudentManagementMappingPractice.Repository;

import com.MappingPractice.StudentManagementMappingPractice.Model.Book;
import com.MappingPractice.StudentManagementMappingPractice.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStuRepo extends JpaRepository<Student,Long> {
}
