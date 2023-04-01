package com.jdsk.people.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jdsk.people.entities.DailyRoutine;

public interface DailyRoutineRepository extends JpaRepository<DailyRoutine, Integer> {

}
