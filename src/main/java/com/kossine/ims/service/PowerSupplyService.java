package com.kossine.ims.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.kossine.ims.exceptions.ModelNotFoundException;
import com.kossine.ims.models.PowerSupply;
import com.kossine.ims.repository.PowerSupplyRepo;


@Service
public class PowerSupplyService {

	@Autowired
	PowerSupplyRepo powersupplyRepo;

	public List<PowerSupply> findAllPowerSupply(Pageable pageable) {

		return powersupplyRepo.findAll(pageable);
	}

	public PowerSupply findPowerSupplyById(Long id) throws ModelNotFoundException {

		PowerSupply e = powersupplyRepo.findOne(id);
		if (e == null)
			throw new ModelNotFoundException("PowerSupply was not found ", "PowerSupply was not found with id " + id);
		return e;
	}

	public Long savePowerSupplyToDB(PowerSupply e)  {

		powersupplyRepo.save(e);
		return powersupplyRepo.findByTag(e.getPowersupplyTag()).getId();

	}

	public void updatePowerSupply(Long id, PowerSupply e) throws ModelNotFoundException  {
		PowerSupply entry = powersupplyRepo.findOne(id);
		if (entry == null)
			throw new ModelNotFoundException("PowerSupply was not found ", "PowerSupply was not found with id " + id);

		entry.copy(e);
		powersupplyRepo.update(entry);
	}

	public void deletePowerSupplyById(Long id) throws ModelNotFoundException {

		PowerSupply e = powersupplyRepo.findOne(id);

		if (e == null)
			throw new ModelNotFoundException("PowerSupply was not found ", "PowerSupply was not found with id " + id);

		powersupplyRepo.delete(e);

	}
}
