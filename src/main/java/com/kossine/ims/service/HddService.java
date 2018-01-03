package com.kossine.ims.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.kossine.ims.exceptions.ModelNotFoundException;
import com.kossine.ims.models.Hdd;
import com.kossine.ims.repository.HddRepo;
import com.kossine.ims.repository.exceptions.IntegrityConstraintViolationException;

@Service
public class HddService {

	@Autowired
	HddRepo repo;

	public List<Hdd> findAllHdd(Pageable pageable) {

		return repo.findAll(pageable);
	}

	public Hdd findHddById(Long id) throws ModelNotFoundException {

		Hdd e = repo.findOne(id);
		if (e == null)
			throw new ModelNotFoundException("Hdd was not found ", "Hdd was not found with id " + id);
		return e;
	}

	public Long saveHddToDB(Hdd e) throws IntegrityConstraintViolationException {

		repo.save(e);
		return repo.findByTag(e.getHddTag()).getId();

	}

	public void updateHdd(Long id, Hdd e) throws ModelNotFoundException, IntegrityConstraintViolationException {
		Hdd entry = repo.findOne(id);
		if (entry == null)
			throw new ModelNotFoundException("Hdd was not found ", "Hdd was not found with id " + id);

		entry.copy(e);
		repo.update(entry);
	}

	public void deleteHddById(Long id) throws ModelNotFoundException {

		Hdd e = repo.findOne(id);

		if (e == null)
			throw new ModelNotFoundException("Hdd was not found ", "Hdd was not found with id " + id);

		repo.delete(e);

	}
}
