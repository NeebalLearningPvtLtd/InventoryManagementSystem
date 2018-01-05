package com.kossine.ims.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.kossine.ims.exceptions.ModelNotFoundException;
import com.kossine.ims.models.Ram;
import com.kossine.ims.repository.RamRepo;

@Service
public class RamService {

	@Autowired
	RamRepo repo;

	public List<Ram> findAllRam(Pageable pageable) {

		return repo.findAll(pageable);
	}

	public Ram findRamById(Long id) throws ModelNotFoundException {

		Ram e = repo.findOne(id);
		if (e == null)
			throw new ModelNotFoundException("Ram was not found ", "Ram was not found with id " + id);
		return e;
	}

	public Long saveRamToDB(Ram e) {

		repo.save(e);
		return repo.findByTag(e.getRamTag()).getId();

	}

	public void updateRam(Long id, Ram e) throws ModelNotFoundException  {
		Ram entry = repo.findOne(id);
		if (entry == null)
			throw new ModelNotFoundException("Ram was not found ", "Ram was not found with id " + id);

		entry.copy(e);
		repo.update(entry);
	}

	public void deleteRamById(Long id) throws ModelNotFoundException {

		Ram e = repo.findOne(id);

		if (e == null)
			throw new ModelNotFoundException("Ram was not found ", "Ram was not found with id " + id);

		repo.delete(e);

	}
}
