package com.kossine.ims.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.kossine.ims.domain.AdapterUsedByVO;
import com.kossine.ims.exceptions.ModelNotFoundException;
import com.kossine.ims.models.Adapter;
import com.kossine.ims.models.AdapterUsedBy;
import com.kossine.ims.repository.AdapterRepo;
import com.kossine.ims.repository.AdapterUsedByRepo;

@Service
public class AdapterUsedByService {
	private AdapterRepo adapterRepo;
	private AdapterUsedByRepo adapterUsedByRepo;

	public AdapterUsedByService(AdapterRepo adapterRepo, AdapterUsedByRepo adapterUsedByRepo) {
		this.adapterRepo = adapterRepo;
		this.adapterUsedByRepo = adapterUsedByRepo;
	}

	public Long saveAdapterByAdapterTag(String adaptertag, String location) throws ModelNotFoundException {

		Adapter l = adapterRepo.findByTag(adaptertag);
		if (l == null)
			throw new ModelNotFoundException("provide valid adaptertag",
					"Adapter was not found with adaptertag " + adaptertag);
		AdapterUsedBy entry = new AdapterUsedBy();
		entry.setAdapter(l);
		entry.setLocation(location);
		return adapterUsedByRepo.save(entry).getId();
	}

	public List<AdapterUsedByVO> getAllAdaptersUsedPaged(Pageable pageable) {

		return adapterUsedByRepo.findAllWithJoin(pageable).stream().map(e -> {
			AdapterUsedByVO domain = new AdapterUsedByVO();
			domain.setId(e.getId());
			domain.setLocation(e.getLocation());
			domain.setTime(e.getTime());
			if (e.getAdapter() != null)
				domain.setAdapter_id(e.getAdapter().getId());
			return domain;
		}).collect(Collectors.toList());

	}

	public List<AdapterUsedByVO> getAllAdaptersUsedWithLocationQueryPaged(String locationQuery, Pageable pageable) {

		return adapterUsedByRepo.findAllByLocationQuery(locationQuery, pageable).stream().map(e -> {
			AdapterUsedByVO domain = new AdapterUsedByVO();
			domain.setId(e.getId());
			domain.setLocation(e.getLocation());
			domain.setTime(e.getTime());
			if (e.getAdapter() != null)
				domain.setAdapter_id(e.getAdapter().getId());
			return domain;
		}).collect(Collectors.toList());
	}

	public void updateAdapterUsedByLocation(Long id, String location) throws ModelNotFoundException {
		AdapterUsedBy entity = adapterUsedByRepo.findOne(id);
		if (entity == null)
			throw new ModelNotFoundException("provide a valid adapterusage id", " Entity not found with id " + id);
		entity.setLocation(location);
		adapterUsedByRepo.save(entity);
	}

	public void deleteAdapterUsedByEntry(Long id) throws ModelNotFoundException {
		if (adapterUsedByRepo.findOne(id) == null)
			throw new ModelNotFoundException("provide a valid adapterusage id ", " Entity not found with id " + id);
		adapterUsedByRepo.delete(id);
	}
}
