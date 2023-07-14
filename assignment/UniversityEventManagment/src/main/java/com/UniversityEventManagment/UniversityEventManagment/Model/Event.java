package com.UniversityEventManagment.UniversityEventManagment.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Event {
    @Id
    private Long EveId;

    private String EveName;

    private String LocationOfEvent;

    private LocalDate eveDate;

    private LocalTime StartTime;

    private LocalTime EndTime;

}
