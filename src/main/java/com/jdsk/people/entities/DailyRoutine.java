package com.jdsk.people.entities;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "daily_routine")
public class DailyRoutine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "activity")
    private String activity;

    @Column(name = "duration_minutes")
    private Integer durationMinutes;
    
}