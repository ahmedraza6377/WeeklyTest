package com.MappingPractice.StudentManagementMappingPractice.Repository;

import com.MappingPractice.StudentManagementMappingPractice.Model.Book;
import com.MappingPractice.StudentManagementMappingPractice.Model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICourseRepo extends JpaRepository<Course,Long> {
}
