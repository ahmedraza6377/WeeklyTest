package com.UniversityEventManagment.UniversityEventManagment.Repo;

import com.UniversityEventManagment.UniversityEventManagment.Model.Event;
import com.UniversityEventManagment.UniversityEventManagment.Model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IEventRepo extends CrudRepository<Event,Long> {
    List<Event> findByeveDate(LocalDate date);
}
