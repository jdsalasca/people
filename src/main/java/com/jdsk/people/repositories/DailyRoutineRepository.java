package com.jdsk.people.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jdsk.people.entities.DailyRoutine;

public interface DailyRoutineRepository extends JpaRepository<DailyRoutine, Integer> {

	List<DailyRoutine> findAllByActivity(String activity);

}
