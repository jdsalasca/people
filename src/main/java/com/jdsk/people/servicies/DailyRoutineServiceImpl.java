package com.jdsk.people.servicies;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jdsk.people.dtos.DailyRoutineDto;
import com.jdsk.people.entities.DailyRoutine;
import com.jdsk.people.interfaces.ICrudInterface;
import com.jdsk.people.interfaces.IDailyRoutineService;
import com.jdsk.people.repositories.DailyRoutineRepository;
import com.jdsk.people.utils.response.DefaultResponse;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
@Service
public class DailyRoutineServiceImpl extends CrudServiceImpl<DailyRoutine, DailyRoutineDto,  Integer, DailyRoutineRepository>
implements  IDailyRoutineService{
	private DailyRoutineRepository repository;
	

	@Override
	public ResponseEntity<DefaultResponse<DailyRoutine>> getByActivity(String activity) {
		
		List<DailyRoutine> activities = repository.findAllByActivity(activity);
		
		return null;
	}
	@Override
	public ResponseEntity<DefaultResponse<DailyRoutine>> getById(Integer id) {
		
		return super.getById(id);
	}
	
	
	
	
	
	
	
	

}
