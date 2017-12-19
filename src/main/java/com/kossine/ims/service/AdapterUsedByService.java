package com.kossine.ims.service;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.kossine.ims.exceptions.ModelNotFoundException;
import com.kossine.ims.models.Adapter;
import com.kossine.ims.models.AdapterUsedBy;
import com.kossine.ims.repository.AdapterRepo;
import com.kossine.ims.repository.AdapterUsedByRepo;

@Service
public class AdapterUsedByService {
	private AdapterRepo adapterRepo;
	private AdapterUsedByRepo usedbyRepo;

	public AdapterUsedByService(AdapterRepo adapterRepo, AdapterUsedByRepo usedbyRepo) {
		this.adapterRepo = adapterRepo;
		this.usedbyRepo = usedbyRepo;
	}

	public Long saveAdapterByAdapterTag(String adaptertag, String location) throws ModelNotFoundException {

		Adapter l = adapterRepo.findByTag(adaptertag);
		if (l == null)
			throw new ModelNotFoundException("provide valid adaptertag",
					"Adapter was not found with adaptertag " + adaptertag);
		AdapterUsedBy entry = new AdapterUsedBy();
		entry.setAdapter(l);
		entry.setLocation(location);
		return usedbyRepo.save(entry).getId();
	}


	public List<AdapterUsedBy> getAllAdaptersUsedPaged(Pageable pageable) {
		
		return usedbyRepo.findAllWithJoin(pageable);
	}
	
	public List<AdapterUsedBy> getAllAdaptersUsedWithLocationQueryPaged(String locationQuery,Pageable pageable) {

		return usedbyRepo.findAllByLocationQuery(locationQuery , pageable);
	}
	
	public void updateAdapterUsedByLocation(Long id, String location) throws ModelNotFoundException{
		AdapterUsedBy entity=usedbyRepo.findOne(id);
		if(entity==null)
			throw new ModelNotFoundException("provide a valid adapterusage id" , " Entity not found with id " + id);
		entity.setLocation(location);
		usedbyRepo.save(entity);
	}
	public void deleteAdapterUsedByEntry(Long id) throws ModelNotFoundException {
		if (usedbyRepo.findOne(id) == null)
			throw new ModelNotFoundException("provide a valid adapterusage id ", " Entity not found with id " + id);
		usedbyRepo.delete(id);
	}
}
