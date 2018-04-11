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
	RamRepo ramRepo;

	public List<Ram> findAllRam(Pageable pageable) {

		return ramRepo.findAll(pageable);
	}

	public Ram findRamById(Long id) throws ModelNotFoundException {

		Ram e = ramRepo.findOne(id);
		if (e == null)
			throw new ModelNotFoundException("Ram was not found ", "Ram was not found with id " + id);
		return e;
	}

	public Long saveRamToDB(Ram e) {

		ramRepo.save(e);
		return ramRepo.findByTag(e.getRamTag()).getId();

	}

	public void updateRam(Long id, Ram e) throws ModelNotFoundException  {
		Ram entry = ramRepo.findOne(id);
		if (entry == null)
			throw new ModelNotFoundException("Ram was not found ", "Ram was not found with id " + id);

		entry.copy(e);
		ramRepo.update(entry);
	}

	public void deleteRamById(Long id) throws ModelNotFoundException {

		Ram e = ramRepo.findOne(id);

		if (e == null)
			throw new ModelNotFoundException("Ram was not found ", "Ram was not found with id " + id);

		ramRepo.delete(e);

	}
}
