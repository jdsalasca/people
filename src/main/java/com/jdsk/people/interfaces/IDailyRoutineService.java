package com.jdsk.people.interfaces;

import com.jdsk.people.dtos.DailyRoutineDto;
import com.jdsk.people.entities.DailyRoutine;
import com.jdsk.people.repositories.DailyRoutineRepository;

public interface IDailyRoutineService  extends ICrudInterface<DailyRoutine, DailyRoutineDto,  Integer, DailyRoutineRepository>  {

}
