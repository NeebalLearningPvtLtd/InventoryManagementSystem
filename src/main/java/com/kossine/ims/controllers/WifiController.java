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
import com.kossine.ims.models.Wifi;
import com.kossine.ims.service.WifiService;

@RestController
@RequestMapping("/wifi")
public class WifiController {

	@Autowired
	WifiService wifiService;

	@GetMapping("/get/all")
	public List<Wifi> getAll(@PageableDefault(page=0 , size=20) Pageable pageable)  {
		
		return wifiService.findAllWifi(pageable);
	}

	@GetMapping("/get/{id:\\d+}")
	public ResponseEntity<?> get(@PathVariable Long id) throws ModelNotFoundException {

		return ResponseEntity.ok(wifiService.findWifiById(id));
	}

	@PostMapping(path = "/add", produces = "application/json")
	public ResponseEntity<?> addWifi(@Valid @RequestBody Wifi wifi){

		return ResponseEntity.ok("{ \"id\" : " + wifiService.saveWifiToDB(wifi) + "}");
	}

	@PutMapping("/{id:\\d+}")
	public ResponseEntity<?> updateWifi(@PathVariable Long id, @RequestBody Wifi wifi)
			throws ModelNotFoundException  {
		wifiService.updateWifi(id, wifi);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/{id:\\d+}")
	public ResponseEntity<?> deleteWifiById(@PathVariable Long id) throws ModelNotFoundException {
		wifiService.deleteWifiById(id);
		return ResponseEntity.ok().build();
	}
}
