package com.kossine.ims.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.kossine.ims.exceptions.ModelNotFoundException;
import com.kossine.ims.models.Hdd;
import com.kossine.ims.repository.HddRepo;

@Service
public class HddService {

	@Autowired
	HddRepo hddRepo;

	public List<Hdd> findAllHdd(Pageable pageable) {

		return hddRepo.findAll(pageable);
	}

	public Hdd findHddById(Long id) throws ModelNotFoundException {

		Hdd e = hddRepo.findOne(id);
		if (e == null)
			throw new ModelNotFoundException("Hdd was not found ", "Hdd was not found with id " + id);
		return e;
	}

	public Long saveHddToDB(Hdd e)   {

		hddRepo.save(e);
		return hddRepo.findByTag(e.getHddTag()).getId();

	}

	public void updateHdd(Long id, Hdd e) throws ModelNotFoundException  {
		Hdd entry = hddRepo.findOne(id);
		if (entry == null)
			throw new ModelNotFoundException("Hdd was not found ", "Hdd was not found with id " + id);

		entry.copy(e);
		hddRepo.update(entry);
	}

	public void deleteHddById(Long id) throws ModelNotFoundException {

		Hdd e = hddRepo.findOne(id);

		if (e == null)
			throw new ModelNotFoundException("Hdd was not found ", "Hdd was not found with id " + id);

		hddRepo.delete(e);

	}
}
