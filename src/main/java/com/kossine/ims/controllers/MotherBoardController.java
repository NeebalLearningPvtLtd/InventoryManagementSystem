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
import com.kossine.ims.models.MotherBoard;
import com.kossine.ims.service.MotherBoardService;

@RestController
@RequestMapping("/motherboard")
public class MotherBoardController {

	@Autowired
	MotherBoardService motherboardService;

	@GetMapping("/get/all")
	public List<MotherBoard> getAll(@PageableDefault(page=0 , size=20) Pageable pageable)  {
		
		return motherboardService.findAllMotherBoard(pageable);
	}

	@GetMapping("/get/{id:\\d+}")
	public ResponseEntity<?> get(@PathVariable Long id) throws ModelNotFoundException {

		return ResponseEntity.ok(motherboardService.findMotherBoardById(id));
	}

	@PostMapping(path = "/add", produces = "application/json")
	public ResponseEntity<?> addMotherBoard(@Valid @RequestBody MotherBoard motherboard) {

		return ResponseEntity.ok("{ \"id\" : " + motherboardService.saveMotherBoardToDB(motherboard) + "}");
	}

	@PutMapping("/{id:\\d+}")
	public ResponseEntity<?> updateMotherBoard(@PathVariable Long id, @RequestBody MotherBoard motherboard)
			throws ModelNotFoundException  {
		motherboardService.updateMotherBoard(id, motherboard);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/{id:\\d+}")
	public ResponseEntity<?> deleteMotherBoardById(@PathVariable Long id) throws ModelNotFoundException {
		motherboardService.deleteMotherBoardById(id);
		return ResponseEntity.ok().build();
	}
}
