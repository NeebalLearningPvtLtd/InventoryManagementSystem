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
import com.kossine.ims.service.AdapterUsedByService;

@RestController
@RequestMapping("/adapterusage")
public class AdapterUsedByController {

	@Autowired
	private AdapterUsedByService adapterUsedByService;

	@GetMapping("/get/all")
	public ResponseEntity<?> getAllAdapterUsedByWithOptionalQuery(
			@RequestParam(name = "location", required = false) String locationQuery,
			@PageableDefault(page = 0, value = 10) Pageable pageable) {

		if (StringUtils.isEmpty(locationQuery))
			return ResponseEntity.ok(adapterUsedByService.getAllAdaptersUsedPaged(pageable));

		return ResponseEntity.ok(adapterUsedByService.getAllAdaptersUsedWithLocationQueryPaged(locationQuery, pageable));

	}

	@PostMapping(path = "/add", produces = "application/json")
	public ResponseEntity<?> addAdapterByAdapterTagAndLocation(@RequestBody Map<String, Object> payload)
			throws ModelNotFoundException {

		String adaptertag = (String) payload.get("adapterTag");
		String location = (String) payload.get("location");
		if (adaptertag == null || location == null)
			return ResponseEntity.badRequest().body(new ApiError(HttpStatus.BAD_REQUEST,
					"required json body parameters is not valid", "adapterTag and location required"));

		return ResponseEntity.ok().body("{ \"id\":" + adapterUsedByService.saveAdapterByAdapterTag(adaptertag, location) + "}");

	}

	@PutMapping("/{id:\\d+}")
	public ResponseEntity<?> updateAdapterUsedBy(@PathVariable("id") Long id, @RequestBody Map<String, Object> payload)
			throws ModelNotFoundException {

		String location = (String) payload.get("location");
		if (location == null)
			return ResponseEntity.badRequest().body(new ApiError(HttpStatus.BAD_REQUEST,
					"only location update is available", "location key was not found"));

		adapterUsedByService.updateAdapterUsedByLocation(id, location);
		return ResponseEntity.ok().build();

	}

	@DeleteMapping("/{id:\\d+}")
	public ResponseEntity<?> deleteAdapterUsedBybasedOnId(@PathVariable("id") Long id) throws ModelNotFoundException {

		adapterUsedByService.deleteAdapterUsedByEntry(id);
		return ResponseEntity.ok().build();

	}
}
