package com.kossine.ims.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.kossine.ims.exceptions.ModelNotFoundException;
import com.kossine.ims.models.MotherBoard;
import com.kossine.ims.repository.MotherBoardRepo;

@Service
public class MotherBoardService {

	@Autowired
	MotherBoardRepo motherboardRepo;

	public List<MotherBoard> findAllMotherBoard(Pageable pageable) {

		return motherboardRepo.findAll(pageable);
	}

	public MotherBoard findMotherBoardById(Long id) throws ModelNotFoundException {

		MotherBoard e = motherboardRepo.findOne(id);
		if (e == null)
			throw new ModelNotFoundException("MotherBoard was not found ", "MotherBoard was not found with id " + id);
		return e;
	}

	public Long saveMotherBoardToDB(MotherBoard e)   {

		motherboardRepo.save(e);
		return motherboardRepo.findByTag(e.getMotherboardTag()).getId();

	}

	public void updateMotherBoard(Long id, MotherBoard e) throws ModelNotFoundException {
		MotherBoard entry = motherboardRepo.findOne(id);
		if (entry == null)
			throw new ModelNotFoundException("MotherBoard was not found ", "MotherBoard was not found with id " + id);

		entry.copy(e);
		motherboardRepo.update(entry);
	}

	public void deleteMotherBoardById(Long id) throws ModelNotFoundException {

		MotherBoard e = motherboardRepo.findOne(id);

		if (e == null)
			throw new ModelNotFoundException("MotherBoard was not found ", "MotherBoard was not found with id " + id);

		motherboardRepo.delete(e);

	}
}
