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

import com.kossine.ims.domain.PcVO;
import com.kossine.ims.exceptions.ModelNotFoundException;
import com.kossine.ims.service.PcService;

@RestController
@RequestMapping("/pc")
public class PcController {

	@Autowired
	PcService pcService;

	@GetMapping("/get/all")
	public List<PcVO> getAll(@PageableDefault(page=0 , size=20) Pageable pageable)  {
		
		return pcService.findAllPc(pageable);
	}

	@GetMapping("/get/{id:\\d+}")
	public ResponseEntity<?> get(@PathVariable Long id) throws ModelNotFoundException {

		return ResponseEntity.ok(pcService.findPcById(id));
	}

	@PostMapping(path = "/add", produces = "application/json")
	public ResponseEntity<?> addPc(@Valid @RequestBody PcVO pc)   {
		return ResponseEntity.ok("{ \"id\" : " + pcService.savePcToDB(pc) + "}");
	}

	@PutMapping("/{id:\\d+}")
	public ResponseEntity<?> updatePc(@PathVariable Long id, @RequestBody PcVO pc)
			throws ModelNotFoundException  {
		pcService.updatePc(id, pc);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/{id:\\d+}")
	public ResponseEntity<?> deletePcById(@PathVariable Long id) throws ModelNotFoundException {
		pcService.deletePcById(id);
		return ResponseEntity.ok().build();
	}
}
