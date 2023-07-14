package com.UniversityEventManagment.UniversityEventManagment.Repo;

import com.UniversityEventManagment.UniversityEventManagment.Model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStuRepo extends CrudRepository<Student,Long> {
}
