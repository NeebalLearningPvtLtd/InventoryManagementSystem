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
import com.kossine.ims.models.Hdd;
import com.kossine.ims.service.HddService;

@RestController
@RequestMapping("/hdd")
public class HddController {

	@Autowired
	HddService hddService;

	@GetMapping("/get/all")
	public List<Hdd> getAll(@PageableDefault(page=0 , size=20) Pageable pageable)  {
		
		return hddService.findAllHdd(pageable);
	}

	@GetMapping("/get/{id:\\d+}")
	public ResponseEntity<?> get(@PathVariable Long id) throws ModelNotFoundException {

		return ResponseEntity.ok(hddService.findHddById(id));
	}

	@PostMapping(path = "/add", produces = "application/json")
	public ResponseEntity<?> addHdd(@Valid @RequestBody Hdd hdd)   {

		return ResponseEntity.ok("{ \"id\" : " + hddService.saveHddToDB(hdd) + "}");
	}

	@PutMapping("/{id:\\d+}")
	public ResponseEntity<?> updateHdd(@PathVariable Long id, @RequestBody Hdd hdd)
			throws ModelNotFoundException  {
		hddService.updateHdd(id, hdd);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/{id:\\d+}")
	public ResponseEntity<?> deleteHddById(@PathVariable Long id) throws ModelNotFoundException {
		hddService.deleteHddById(id);
		return ResponseEntity.ok().build();
	}
}
