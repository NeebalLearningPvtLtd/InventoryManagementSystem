package com.kossine.ims.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.kossine.ims.exceptions.ModelNotFoundException;
import com.kossine.ims.models.Wifi;
import com.kossine.ims.repository.WifiRepo;
import com.kossine.ims.repository.exceptions.IntegrityConstraintViolationException;

@Service
public class WifiService {

	@Autowired
	WifiRepo repo;

	public List<Wifi> findAllWifi(Pageable pageable) {

		return repo.findAll(pageable);
	}

	public Wifi findWifiById(Long id) throws ModelNotFoundException {

		Wifi e = repo.findOne(id);
		if (e == null)
			throw new ModelNotFoundException("Wifi was not found ", "Wifi was not found with id " + id);
		return e;
	}

	public Long saveWifiToDB(Wifi e) throws IntegrityConstraintViolationException {

		repo.save(e);
		return repo.findByTag(e.getWifiTag()).getId();

	}

	public void updateWifi(Long id, Wifi e) throws ModelNotFoundException, IntegrityConstraintViolationException {
		Wifi entry = repo.findOne(id);
		if (entry == null)
			throw new ModelNotFoundException("Wifi was not found ", "Wifi was not found with id " + id);

		entry.copy(e);
		repo.update(entry);
	}

	public void deleteWifiById(Long id) throws ModelNotFoundException {

		Wifi e = repo.findOne(id);

		if (e == null)
			throw new ModelNotFoundException("Wifi was not found ", "Wifi was not found with id " + id);

		repo.delete(e);

	}
}
