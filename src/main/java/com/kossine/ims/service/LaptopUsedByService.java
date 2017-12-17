package com.kossine.ims.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

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
	public LaptopUsedBy saveLaptopByLaptopTag(String laptoptag,String location) throws EntityNotFoundException{
		
		Laptop l=laptopRepo.findByTag(laptoptag);
		if(l==null) 
			throw new EntityNotFoundException("Laptop was not found with tag "+ laptoptag);
		LaptopUsedBy entry=new LaptopUsedBy();
		entry.setLaptop(l);
		entry.setLocation(location);
		return usedbyRepo.save(entry);
	}
	public List<LaptopUsedBy> getAllLaptopsUsed(){
		return usedbyRepo.findAllWithJoin();
	}
	/*public void deleteLaptopUsedByEntry(String laptoptag){
		
	}*/
}
