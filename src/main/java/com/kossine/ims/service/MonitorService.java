package com.kossine.ims.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.kossine.ims.exceptions.ModelNotFoundException;
import com.kossine.ims.models.Monitor;
import com.kossine.ims.repository.MonitorRepo;

@Service
public class MonitorService {

	@Autowired
	MonitorRepo repo;

	public List<Monitor> findAllMonitor(Pageable pageable) {

		return repo.findAll(pageable);
	}

	public Monitor findMonitorById(Long id) throws ModelNotFoundException {

		Monitor e = repo.findOne(id);
		if (e == null)
			throw new ModelNotFoundException("Monitor was not found ", "Monitor was not found with id " + id);
		return e;
	}

	public Long saveMonitorToDB(Monitor e) {

		repo.save(e);
		return repo.findByTag(e.getMonitorTag()).getId();

	}

	public void updateMonitor(Long id, Monitor e) throws ModelNotFoundException {
		Monitor entry = repo.findOne(id);
		if (entry == null)
			throw new ModelNotFoundException("Monitor was not found ", "Monitor was not found with id " + id);

		entry.copy(e);
		repo.update(entry);
	}

	public void deleteMonitorById(Long id) throws ModelNotFoundException {

		Monitor e = repo.findOne(id);

		if (e == null)
			throw new ModelNotFoundException("Monitor was not found ", "Monitor was not found with id " + id);

		repo.delete(e);

	}
}
