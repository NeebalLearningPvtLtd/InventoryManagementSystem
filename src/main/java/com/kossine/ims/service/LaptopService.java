package com.kossine.ims.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.kossine.ims.exceptions.ModelNotFoundException;
import com.kossine.ims.models.Laptop;
import com.kossine.ims.repository.LaptopRepo;
import com.kossine.ims.repository.exceptions.IntegrityConstraintViolationException;

@Service
public class LaptopService {

	@Autowired
	LaptopRepo repo;

	public List<Laptop> findAllLaptop(Pageable pageable) {

		return repo.findAll(pageable);
	}

	public Laptop findLaptopById(Long id) throws ModelNotFoundException {

		Laptop e = repo.findOne(id);
		if (e == null)
			throw new ModelNotFoundException("Laptop was not found ", "Laptop was not found with id " + id);
		return e;
	}

	public Long saveLaptopToDB(Laptop e) throws IntegrityConstraintViolationException {

		repo.save(e);
		return repo.findByTag(e.getLaptopTag()).getId();

	}

	public void updateLaptop(Long id, Laptop e) throws ModelNotFoundException, IntegrityConstraintViolationException {
		Laptop entry = repo.findOne(id);
		if (entry == null)
			throw new ModelNotFoundException("Laptop was not found ", "Laptop was not found with id " + id);

		entry.copy(e);
		repo.update(entry);
	}

	public void deleteLaptopById(Long id) throws ModelNotFoundException {

		Laptop e = repo.findOne(id);

		if (e == null)
			throw new ModelNotFoundException("Laptop was not found ", "Laptop was not found with id " + id);

		repo.delete(e);

	}
}
