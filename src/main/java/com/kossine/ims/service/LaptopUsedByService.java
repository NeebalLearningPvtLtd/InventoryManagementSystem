package com.kossine.ims.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.kossine.ims.domain.LaptopUsedByVO;
import com.kossine.ims.exceptions.ModelNotFoundException;
import com.kossine.ims.models.Laptop;
import com.kossine.ims.models.LaptopUsedBy;
import com.kossine.ims.repository.LaptopRepo;
import com.kossine.ims.repository.LaptopUsedByRepo;

@Service
public class LaptopUsedByService {
	private LaptopRepo laptopRepo;
	private LaptopUsedByRepo usedbyRepo;

	public LaptopUsedByService(LaptopRepo laptopRepo, LaptopUsedByRepo usedbyRepo) {
		this.laptopRepo = laptopRepo;
		this.usedbyRepo = usedbyRepo;
	}

	public Long saveLaptopByLaptopTag(String laptoptag, String location) throws ModelNotFoundException {

		Laptop l = laptopRepo.findByTag(laptoptag);
		if (l == null)
			throw new ModelNotFoundException("provide valid laptoptag",
					"Laptop was not found with laptoptag " + laptoptag);
		LaptopUsedBy entry = new LaptopUsedBy();
		entry.setLaptop(l);
		entry.setLocation(location);
		return usedbyRepo.save(entry).getId();
	}

	public List<LaptopUsedByVO> getAllLaptopsUsedPaged(Pageable pageable) {

		return usedbyRepo.findAllWithJoin(pageable).stream().map(e -> {
			LaptopUsedByVO domain = new LaptopUsedByVO();
			domain.setId(e.getId());
			domain.setLocation(e.getLocation());
			domain.setTime(e.getTime());
			if (e.getLaptop() != null)
				domain.setLaptop_id(e.getLaptop().getId());
			return domain;
		}).collect(Collectors.toList());
	}

	public List<LaptopUsedByVO> getAllLaptopsUsedWithLocationQueryPaged(String locationQuery, Pageable pageable) {

		return usedbyRepo.findAllByLocationQuery(locationQuery, pageable).stream().map(e -> {
			LaptopUsedByVO domain = new LaptopUsedByVO();
			domain.setId(e.getId());
			domain.setLocation(e.getLocation());
			domain.setTime(e.getTime());
			if (e.getLaptop() != null)
				domain.setLaptop_id(e.getLaptop().getId());
			return domain;
		}).collect(Collectors.toList());
	}

	public void updateLaptopUsedByLocation(Long id, String location) throws ModelNotFoundException {
		LaptopUsedBy entity = usedbyRepo.findOne(id);
		if (entity == null)
			throw new ModelNotFoundException("provide a valid laptopusage id", " Entity not found with id " + id);
		entity.setLocation(location);
		usedbyRepo.save(entity);
	}

	public void deleteLaptopUsedByEntry(Long id) throws ModelNotFoundException {
		if (usedbyRepo.findOne(id) == null)
			throw new ModelNotFoundException("provide a valid laptopusage id ", " Entity not found with id " + id);
		usedbyRepo.delete(id);
	}
}
