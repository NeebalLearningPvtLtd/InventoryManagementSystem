package com.kossine.ims.controllers;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kossine.ims.models.LaptopUsedBy;
import com.kossine.ims.service.LaptopUsedByService;

@RestController
@RequestMapping("/laptopusedby")
public class LaptopUsedByController {

	@Autowired
	private LaptopUsedByService service;

	@GetMapping("/get/all")
	public List<LaptopUsedBy> getAll() {

		return service.getAllLaptopsUsed();

	}

	@PostMapping(value = "/add")
	public ResponseEntity<?> add(@RequestBody Map<String, Object> payload) {

		String laptoptag = (String) payload.get("laptoptag");
		String location = (String) payload.get("location");
		if (laptoptag == null || location == null)
			return ResponseEntity.badRequest().body("{location , laptoptag required}");

		try {
			return ResponseEntity.ok().body(service.saveLaptopByLaptopTag(laptoptag, location));
		} catch (EntityNotFoundException e) {
			return ResponseEntity.badRequest().body("laptop was not found with laptop tag " + laptoptag);

		}

	}
}
