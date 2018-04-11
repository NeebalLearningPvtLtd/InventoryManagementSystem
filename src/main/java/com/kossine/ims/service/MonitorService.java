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
	MonitorRepo monitorRepo;

	public List<Monitor> findAllMonitor(Pageable pageable) {

		return monitorRepo.findAll(pageable);
	}

	public Monitor findMonitorById(Long id) throws ModelNotFoundException {

		Monitor e = monitorRepo.findOne(id);
		if (e == null)
			throw new ModelNotFoundException("Monitor was not found ", "Monitor was not found with id " + id);
		return e;
	}

	public Long saveMonitorToDB(Monitor e) {

		monitorRepo.save(e);
		return monitorRepo.findByTag(e.getMonitorTag()).getId();

	}

	public void updateMonitor(Long id, Monitor e) throws ModelNotFoundException {
		Monitor entry = monitorRepo.findOne(id);
		if (entry == null)
			throw new ModelNotFoundException("Monitor was not found ", "Monitor was not found with id " + id);

		entry.copy(e);
		monitorRepo.update(entry);
	}

	public void deleteMonitorById(Long id) throws ModelNotFoundException {

		Monitor e = monitorRepo.findOne(id);

		if (e == null)
			throw new ModelNotFoundException("Monitor was not found ", "Monitor was not found with id " + id);

		monitorRepo.delete(e);

	}
}
