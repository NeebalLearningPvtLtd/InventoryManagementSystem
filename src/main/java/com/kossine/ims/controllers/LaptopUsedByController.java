package com.kossine.ims.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kossine.ims.exceptions.ApiError;
import com.kossine.ims.exceptions.ModelNotFoundException;
import com.kossine.ims.service.LaptopUsedByService;

@RestController
@RequestMapping("/laptopusage")
public class LaptopUsedByController {

	@Autowired
	private LaptopUsedByService laptopUsedByService;

	@GetMapping("/get/all")
	public ResponseEntity<?> getAllLaptopUsedByWithOptionalQuery(
			@RequestParam(name = "location", required = false) String locationQuery,
			@PageableDefault(page = 0, value = 10) Pageable pageable) {

		if (StringUtils.isEmpty(locationQuery))
			return ResponseEntity.ok(laptopUsedByService.getAllLaptopsUsedPaged(pageable));

		return ResponseEntity.ok(laptopUsedByService.getAllLaptopsUsedWithLocationQueryPaged(locationQuery, pageable));

	}

	@PostMapping(path="/add", produces = "application/json")
	public ResponseEntity<?> addLaptopByLaptopTagAndLocation(@RequestBody Map<String, Object> payload)
			throws ModelNotFoundException {

		String laptoptag = (String) payload.get("laptopTag");
		String location = (String) payload.get("location");
		if (laptoptag == null || location == null)
			return ResponseEntity.badRequest().body(new ApiError(HttpStatus.BAD_REQUEST,
					"required json body parameters is not valid", "laptopTag and location required"));

		return ResponseEntity.ok().body("{ \"id\":" + laptopUsedByService.saveLaptopByLaptopTag(laptoptag, location) + "}");

	}

	@PutMapping("/{id:\\d+}")
	public ResponseEntity<?> updateLaptopUsedBy(@PathVariable("id") Long id, @RequestBody Map<String, Object> payload)
			throws ModelNotFoundException {

		String location = (String) payload.get("location");
		if (location == null)
			return ResponseEntity.badRequest().body(new ApiError(HttpStatus.BAD_REQUEST,
					"only location update is available", "location key was not found"));

		laptopUsedByService.updateLaptopUsedByLocation(id, location);
		return ResponseEntity.ok().build();

	}

	@DeleteMapping("/{id:\\d+}")
	public ResponseEntity<?> deleteLaptopUsedBybasedOnId(@PathVariable("id") Long id) throws ModelNotFoundException {

		laptopUsedByService.deleteLaptopUsedByEntry(id);
		return ResponseEntity.ok().build();

	}
}
