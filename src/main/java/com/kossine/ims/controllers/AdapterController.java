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
import com.kossine.ims.models.Adapter;
import com.kossine.ims.service.AdapterService;

@RestController
@RequestMapping("/adapter")
public class AdapterController {

	@Autowired
	AdapterService adapterService;

	@GetMapping("/get/all")
	public List<Adapter> getAll(@PageableDefault(page=0 , size=20) Pageable pageable)  {
		
		return adapterService.findAllAdapter(pageable);
	}

	@GetMapping("/get/{id:\\d+}")
	public ResponseEntity<?> get(@PathVariable Long id) throws ModelNotFoundException {

		return ResponseEntity.ok(adapterService.findAdapterById(id));
	}

	@PostMapping(path = "/add", produces = "application/json")
	public ResponseEntity<?> addAdapter(@Valid @RequestBody Adapter adapter)   {

		return ResponseEntity.ok("{ \"id\" : " + adapterService.saveAdapterToDB(adapter) + "}");
	}

	@PutMapping("/{id:\\d+}")
	public ResponseEntity<?> updateAdapter(@PathVariable Long id, @RequestBody Adapter adapter)
			throws ModelNotFoundException  {
		adapterService.updateAdapter(id, adapter);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/{id:\\d+}")
	public ResponseEntity<?> deleteAdapterById(@PathVariable Long id) throws ModelNotFoundException {
		adapterService.deleteAdapterById(id);
		return ResponseEntity.ok().build();
	}
}
