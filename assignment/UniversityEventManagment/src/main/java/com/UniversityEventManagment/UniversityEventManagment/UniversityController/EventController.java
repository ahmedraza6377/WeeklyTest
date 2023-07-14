package com.UniversityEventManagment.UniversityEventManagment.UniversityController;

import com.UniversityEventManagment.UniversityEventManagment.Model.Event;
import com.UniversityEventManagment.UniversityEventManagment.Model.Student;
import com.UniversityEventManagment.UniversityEventManagment.UniService.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
public class EventController {

    @Autowired
    EventService eventService;


    // Endpoint to add an event
    @PostMapping("/events")
    public String addEvent(@RequestBody Event event) {
        eventService.addEvent(event);
        return "Event added successfully";
    }

    // Endpoint to update an event
    @PutMapping("/events/{id}")
   public String EventUpdate(@PathVariable Long id,@RequestBody Event ev){
        return eventService.updateEvent(id,ev);

    }
    // Endpoint to delete an event
    @DeleteMapping("/events/{eventId}")
    public String deleteEvent(@PathVariable Long eventId) {
       eventService.deleteEvent(eventId);
        return "Event deleted successfully";
    }

    // Endpoint to get all events by date
    @GetMapping("/events")
    public String getAllEventsByDate(@RequestParam LocalDate date) {
       eventService.getAllEventsByeveDate(date);
        return "List of events on " + date;
    }
}
