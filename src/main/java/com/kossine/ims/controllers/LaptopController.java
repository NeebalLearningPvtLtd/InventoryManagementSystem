package com.kossine.ims.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kossine.ims.exceptions.ModelNotFoundException;
import com.kossine.ims.models.Laptop;
import com.kossine.ims.service.LaptopService;

@RestController
@RequestMapping("/laptop")
public class LaptopController {

	@Autowired
	LaptopService laptopService;

	@GetMapping("/get/all")
	public List<Laptop> getAll(@PageableDefault(page=0 , size=20) Pageable pageable)  {
		
		return laptopService.findAllLaptop(pageable);
	}

	@GetMapping("/get/{id:\\d+}")
	public ResponseEntity<?> get(@PathVariable Long id) throws ModelNotFoundException {

		return ResponseEntity.ok(laptopService.findLaptopById(id));
	}

	@PostMapping(path = "/add", produces = "application/json")
	public ResponseEntity<?> addLaptop(@Valid @RequestBody Laptop laptop) {

		return ResponseEntity.ok("{ \"id\" : " + laptopService.saveLaptopToDB(laptop) + "}");
	}

	@PutMapping("/{id:\\d+}")
	public ResponseEntity<?> updateLaptop(@PathVariable Long id, @RequestBody Laptop laptop)
			throws ModelNotFoundException  {
		laptopService.updateLaptop(id, laptop);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/{id:\\d+}")
	public ResponseEntity<?> deleteLaptopById(@PathVariable Long id) throws ModelNotFoundException {
		laptopService.deleteLaptopById(id);
		return ResponseEntity.ok().build();
	}
}
