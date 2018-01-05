package com.kossine.ims.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.kossine.ims.exceptions.ModelNotFoundException;
import com.kossine.ims.models.Mouse;
import com.kossine.ims.repository.MouseRepo;

@Service
public class MouseService {

	@Autowired
	MouseRepo repo;
	
	public List<Mouse> findAllMouse(Pageable pageable) {

		return repo.findAll(pageable);
	}

	public Mouse findMouseById(Long id) throws ModelNotFoundException {

		Mouse e = repo.findOne(id);
		if (e == null)
			throw new ModelNotFoundException("Mouse was not found ", "Mouse was not found with id " + id);
		return e;
	}

	public Long saveMouseToDB(Mouse e)  {

		repo.save(e);
		return repo.findByTag(e.getMouseTag()).getId();

	}

	public void updateMouse(Long id, Mouse e) throws ModelNotFoundException{
		Mouse entry = repo.findOne(id);
		if (entry == null)
			throw new ModelNotFoundException("Mouse was not found ", "Mouse was not found with id " + id);

		entry.copy(e);
		repo.update(entry);
	}

	public void deleteMouseById(Long id) throws ModelNotFoundException {

		Mouse e = repo.findOne(id);

		if (e == null)
			throw new ModelNotFoundException("Mouse was not found ", "Mouse was not found with id " + id);

		repo.delete(e);

	}
}
