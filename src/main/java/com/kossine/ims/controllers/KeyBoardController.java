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
import com.kossine.ims.models.KeyBoard;
import com.kossine.ims.service.KeyBoardService;

@RestController
@RequestMapping("/keyboard")
public class KeyBoardController {

	@Autowired
	KeyBoardService keyboardService;

	@GetMapping("/get/all")
	public List<KeyBoard> getAll(@PageableDefault(page=0 , size=20) Pageable pageable)  {
		
		return keyboardService.findAllKeyBoard(pageable);
	}

	@GetMapping("/get/{id:\\d+}")
	public ResponseEntity<?> get(@PathVariable Long id) throws ModelNotFoundException {

		return ResponseEntity.ok(keyboardService.findKeyBoardById(id));
	}

	@PostMapping(path = "/add", produces = "application/json")
	public ResponseEntity<?> addKeyBoard(@Valid @RequestBody KeyBoard keyboard) {

		return ResponseEntity.ok("{ \"id\" : " + keyboardService.saveKeyBoardToDB(keyboard) + "}");
	}

	@PutMapping("/{id:\\d+}")
	public ResponseEntity<?> updateKeyBoard(@PathVariable Long id, @RequestBody KeyBoard keyboard)
			throws ModelNotFoundException  {
		keyboardService.updateKeyBoard(id, keyboard);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/{id:\\d+}")
	public ResponseEntity<?> deleteKeyBoardById(@PathVariable Long id) throws ModelNotFoundException {
		keyboardService.deleteKeyBoardById(id);
		return ResponseEntity.ok().build();
	}
}
