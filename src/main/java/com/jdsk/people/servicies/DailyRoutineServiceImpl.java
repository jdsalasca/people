package com.jdsk.people.servicies;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.jdsk.people.dtos.DailyRoutineDto;
import com.jdsk.people.entities.DailyRoutine;
import com.jdsk.people.interfaces.ICrudInterface;
import com.jdsk.people.interfaces.IDailyRoutineService;
import com.jdsk.people.repositories.DailyRoutineRepository;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
@Service
public class DailyRoutineServiceImpl extends CrudServiceImpl<DailyRoutine, DailyRoutineDto,  Integer, DailyRoutineRepository>
implements  IDailyRoutineService
{

	public DailyRoutineServiceImpl(DailyRoutineRepository repository, ModelMapper modelMapper) {
		super(repository, modelMapper);
		// TODO Auto-generated constructor stub
	}
	
	

}
