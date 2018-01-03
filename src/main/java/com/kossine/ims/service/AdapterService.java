package com.kossine.ims.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.kossine.ims.exceptions.ModelNotFoundException;
import com.kossine.ims.models.Adapter;
import com.kossine.ims.repository.AdapterRepo;
import com.kossine.ims.repository.exceptions.IntegrityConstraintViolationException;

@Service
public class AdapterService {

	@Autowired
	AdapterRepo repo;

	public List<Adapter> findAllAdapter(Pageable pageable) {

		return repo.findAll(pageable);
	}

	public Adapter findAdapterById(Long id) throws ModelNotFoundException {

		Adapter e = repo.findOne(id);
		if (e == null)
			throw new ModelNotFoundException("Adapter was not found ", "Adapter was not found with id " + id);
		return e;
	}

	public Long saveAdapterToDB(Adapter e) throws IntegrityConstraintViolationException {

		repo.save(e);
		return repo.findByTag(e.getAdapterTag()).getId();

	}

	public void updateAdapter(Long id, Adapter e) throws ModelNotFoundException, IntegrityConstraintViolationException {
		Adapter entry = repo.findOne(id);
		if (entry == null)
			throw new ModelNotFoundException("Adapter was not found ", "Adapter was not found with id " + id);

		entry.copy(e);
		repo.update(entry);
	}

	public void deleteAdapterById(Long id) throws ModelNotFoundException {

		Adapter e = repo.findOne(id);

		if (e == null)
			throw new ModelNotFoundException("Adapter was not found ", "Adapter was not found with id " + id);

		repo.delete(e);

	}
}
