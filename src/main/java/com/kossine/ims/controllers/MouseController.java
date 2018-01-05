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
import com.kossine.ims.models.Mouse;
import com.kossine.ims.service.MouseService;

@RestController
@RequestMapping("/mouse")
public class MouseController {

	@Autowired
	MouseService service;

	@GetMapping("/get/all")
	public List<Mouse> getAll(@PageableDefault(page=0 , size=20) Pageable pageable)  {
		
		return service.findAllMouse(pageable);
	}

	@GetMapping("/get/{id:\\d+}")
	public ResponseEntity<?> get(@PathVariable Long id) throws ModelNotFoundException {

		return ResponseEntity.ok(service.findMouseById(id));
	}

	@PostMapping(path = "/add", produces = "application/json")
	public ResponseEntity<?> addMouse(@Valid @RequestBody Mouse mouse){

		return ResponseEntity.ok("{ \"id\" : " + service.saveMouseToDB(mouse) + "}");
	}

	@PutMapping("/{id:\\d+}")
	public ResponseEntity<?> updateMouse(@PathVariable Long id, @RequestBody Mouse mouse)
			throws ModelNotFoundException  {
		service.updateMouse(id, mouse);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/{id:\\d+}")
	public ResponseEntity<?> deleteMouseById(@PathVariable Long id) throws ModelNotFoundException {
		service.deleteMouseById(id);
		return ResponseEntity.ok().build();
	}
}
