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
import com.kossine.ims.models.Ram;
import com.kossine.ims.service.RamService;

@RestController
@RequestMapping("/ram")
public class RamController {

	@Autowired
	RamService ramService;

	@GetMapping("/get/all")
	public List<Ram> getAll(@PageableDefault(page=0 , size=20) Pageable pageable)  {
		
		return ramService.findAllRam(pageable);
	}

	@GetMapping("/get/{id:\\d+}")
	public ResponseEntity<?> get(@PathVariable Long id) throws ModelNotFoundException {

		return ResponseEntity.ok(ramService.findRamById(id));
	}

	@PostMapping(path = "/add", produces = "application/json")
	public ResponseEntity<?> addRam(@Valid @RequestBody Ram ram){

		return ResponseEntity.ok("{ \"id\" : " + ramService.saveRamToDB(ram) + "}");
	}

	@PutMapping("/{id:\\d+}")
	public ResponseEntity<?> updateRam(@PathVariable Long id, @RequestBody Ram ram)
			throws ModelNotFoundException  {
		ramService.updateRam(id, ram);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/{id:\\d+}")
	public ResponseEntity<?> deleteRamById(@PathVariable Long id) throws ModelNotFoundException {
		ramService.deleteRamById(id);
		return ResponseEntity.ok().build();
	}
}
