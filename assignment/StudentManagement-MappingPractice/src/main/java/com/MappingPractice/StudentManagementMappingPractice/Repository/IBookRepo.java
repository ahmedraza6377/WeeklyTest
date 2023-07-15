package com.MappingPractice.StudentManagementMappingPractice.Repository;

import com.MappingPractice.StudentManagementMappingPractice.Model.Address;
import com.MappingPractice.StudentManagementMappingPractice.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookRepo extends JpaRepository<Book,Long> {
}
