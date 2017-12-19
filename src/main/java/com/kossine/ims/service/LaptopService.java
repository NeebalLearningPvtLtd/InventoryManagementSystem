package com.kossine.ims.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kossine.ims.repository.LaptopRepo;

@Service
public class LaptopService {

	@Autowired
	LaptopRepo repo;
	
	
}
