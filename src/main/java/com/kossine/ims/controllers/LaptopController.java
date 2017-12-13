package com.kossine.ims.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kossine.ims.models.Laptop;
import com.kossine.ims.repository.ILaptopRepo;

@RestController

public class LaptopController {
	
	@Autowired
	ILaptopRepo repo;
	
	@RequestMapping("/laptop/getAll")
	public List<Laptop> getAll() {
	return repo.findAll();
	}
}
