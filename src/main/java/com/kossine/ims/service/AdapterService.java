package com.kossine.ims.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.kossine.ims.exceptions.ModelNotFoundException;
import com.kossine.ims.models.Adapter;
import com.kossine.ims.repository.AdapterRepo;

@Service
public class AdapterService {

	@Autowired
	AdapterRepo adapterRepo;

	public List<Adapter> findAllAdapter(Pageable pageable) {

		return adapterRepo.findAll(pageable);
	}

	public Adapter findAdapterById(Long id) throws ModelNotFoundException {

		Adapter e = adapterRepo.findOne(id);
		if (e == null)
			throw new ModelNotFoundException("Adapter was not found ", "Adapter was not found with id " + id);
		return e;
	}

	public Long saveAdapterToDB(Adapter e)  {

		adapterRepo.save(e);
		return adapterRepo.findByTag(e.getAdapterTag()).getId();

	}

	public void updateAdapter(Long id, Adapter e) throws ModelNotFoundException {
		Adapter entry = adapterRepo.findOne(id);
		if (entry == null)
			throw new ModelNotFoundException("Adapter was not found ", "Adapter was not found with id " + id);

		entry.copy(e);
		adapterRepo.update(entry);
	}

	public void deleteAdapterById(Long id) throws ModelNotFoundException {

		Adapter e = adapterRepo.findOne(id);

		if (e == null)
			throw new ModelNotFoundException("Adapter was not found ", "Adapter was not found with id " + id);

		adapterRepo.delete(e);

	}
}
