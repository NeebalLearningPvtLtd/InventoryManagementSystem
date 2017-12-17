package com.kossine.ims.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kossine.ims.models.Laptop;
import com.kossine.ims.repository.LaptopRepo;

@RestController
@RequestMapping("/laptop")
public class LaptopController {
	
	@Autowired
	LaptopRepo repo;
	
	@GetMapping("/get/all")
	public List<Laptop> getAll() {
	return repo.findAll();
	}
	
	@GetMapping("/get/{id}")
	public Laptop get(@PathVariable Long id) {
		return repo.findOne(id);
	}
	@PostMapping("/add")
	public ResponseEntity<Laptop> addLaptop(@RequestBody Map<String,Object> map){
		
		return null;
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Laptop> deleteLaptopById(@PathVariable Long id){
	
		return null;
	}
}
