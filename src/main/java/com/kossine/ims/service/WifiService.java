package com.kossine.ims.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.kossine.ims.exceptions.ModelNotFoundException;
import com.kossine.ims.models.Wifi;
import com.kossine.ims.repository.WifiRepo;

@Service
public class WifiService {

	@Autowired
	WifiRepo wifiRepo;

	public List<Wifi> findAllWifi(Pageable pageable) {

		return wifiRepo.findAll(pageable);
	}

	public Wifi findWifiById(Long id) throws ModelNotFoundException {

		Wifi e = wifiRepo.findOne(id);
		if (e == null)
			throw new ModelNotFoundException("Wifi was not found ", "Wifi was not found with id " + id);
		return e;
	}

	public Long saveWifiToDB(Wifi e) {

		wifiRepo.save(e);
		return wifiRepo.findByTag(e.getWifiTag()).getId();

	}

	public void updateWifi(Long id, Wifi e) throws ModelNotFoundException  {
		Wifi entry = wifiRepo.findOne(id);
		if (entry == null)
			throw new ModelNotFoundException("Wifi was not found ", "Wifi was not found with id " + id);

		entry.copy(e);
		wifiRepo.update(entry);
	}

	public void deleteWifiById(Long id) throws ModelNotFoundException {

		Wifi e = wifiRepo.findOne(id);

		if (e == null)
			throw new ModelNotFoundException("Wifi was not found ", "Wifi was not found with id " + id);

		wifiRepo.delete(e);

	}
}
