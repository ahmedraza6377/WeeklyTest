package com.UniversityEventManagment.UniversityEventManagment.UniService;

import com.UniversityEventManagment.UniversityEventManagment.Model.Event;
import com.UniversityEventManagment.UniversityEventManagment.Model.Student;
import com.UniversityEventManagment.UniversityEventManagment.Repo.IEventRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EventService {

    @Autowired
    IEventRepo eventRepo;


    public void addEvent(Event ev) {
        eventRepo.save(ev);
    }

    public void deleteEvent(Long eventId) {
        eventRepo.deleteById(eventId);
    }

    public List<Event> getAllEventsByeveDate(LocalDate date) {
        return eventRepo.findByeveDate(date);
    }

    public String updateEvent(Long id, Event ev) {
        Event event=eventRepo.findById(id).orElse(null);
        if (event != null) {

            eventRepo.save(event);
            return "updated";
        }
        return "id not found";
    }
}
