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
import com.kossine.ims.models.Monitor;
import com.kossine.ims.service.MonitorService;

@RestController
@RequestMapping("/monitor")
public class MonitorController {

	@Autowired
	MonitorService monitorService;

	@GetMapping("/get/all")
	public List<Monitor> getAll(@PageableDefault(page=0 , size=20) Pageable pageable)  {
		
		return monitorService.findAllMonitor(pageable);
	}

	@GetMapping("/get/{id:\\d+}")
	public ResponseEntity<?> get(@PathVariable Long id) throws ModelNotFoundException {

		return ResponseEntity.ok(monitorService.findMonitorById(id));
	}

	@PostMapping(path = "/add", produces = "application/json")
	public ResponseEntity<?> addMonitor(@Valid @RequestBody Monitor monitor){

		return ResponseEntity.ok("{ \"id\" : " + monitorService.saveMonitorToDB(monitor) + "}");
	}

	@PutMapping("/{id:\\d+}")
	public ResponseEntity<?> updateMonitor(@PathVariable Long id, @RequestBody Monitor monitor)
			throws ModelNotFoundException  {
		monitorService.updateMonitor(id, monitor);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/{id:\\d+}")
	public ResponseEntity<?> deleteMonitorById(@PathVariable Long id) throws ModelNotFoundException {
		monitorService.deleteMonitorById(id);
		return ResponseEntity.ok().build();
	}
}
