package com.jdsk.people.interfaces;

import org.springframework.http.ResponseEntity;

import com.jdsk.people.dtos.DailyRoutineDto;
import com.jdsk.people.entities.DailyRoutine;
import com.jdsk.people.repositories.DailyRoutineRepository;
import com.jdsk.people.utils.response.DefaultResponse;

public interface IDailyRoutineService  extends ICrudInterface<DailyRoutine, DailyRoutineDto,  Integer, DailyRoutineRepository>  {
		ResponseEntity<DefaultResponse<DailyRoutine>>  getByActivity(String activy);
}
