package com.kossine.ims.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.kossine.ims.exceptions.ModelNotFoundException;
import com.kossine.ims.models.MotherBoard;
import com.kossine.ims.repository.MotherBoardRepo;
import com.kossine.ims.repository.exceptions.IntegrityConstraintViolationException;

@Service
public class MotherBoardService {

	@Autowired
	MotherBoardRepo repo;

	public List<MotherBoard> findAllMotherBoard(Pageable pageable) {

		return repo.findAll(pageable);
	}

	public MotherBoard findMotherBoardById(Long id) throws ModelNotFoundException {

		MotherBoard e = repo.findOne(id);
		if (e == null)
			throw new ModelNotFoundException("MotherBoard was not found ", "MotherBoard was not found with id " + id);
		return e;
	}

	public Long saveMotherBoardToDB(MotherBoard e) throws IntegrityConstraintViolationException {

		repo.save(e);
		return repo.findByTag(e.getMotherboardTag()).getId();

	}

	public void updateMotherBoard(Long id, MotherBoard e) throws ModelNotFoundException, IntegrityConstraintViolationException {
		MotherBoard entry = repo.findOne(id);
		if (entry == null)
			throw new ModelNotFoundException("MotherBoard was not found ", "MotherBoard was not found with id " + id);

		entry.copy(e);
		repo.update(entry);
	}

	public void deleteMotherBoardById(Long id) throws ModelNotFoundException {

		MotherBoard e = repo.findOne(id);

		if (e == null)
			throw new ModelNotFoundException("MotherBoard was not found ", "MotherBoard was not found with id " + id);

		repo.delete(e);

	}
}
