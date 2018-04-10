package com.kossine.ims.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.kossine.ims.exceptions.ModelNotFoundException;
import com.kossine.ims.models.KeyBoard;
import com.kossine.ims.repository.KeyBoardRepo;

@Service
public class KeyBoardService {

	@Autowired
	KeyBoardRepo keyboardRepo;

	public List<KeyBoard> findAllKeyBoard(Pageable pageable) {

		return keyboardRepo.findAll(pageable);
	}

	public KeyBoard findKeyBoardById(Long id) throws ModelNotFoundException {

		KeyBoard e = keyboardRepo.findOne(id);
		if (e == null)
			throw new ModelNotFoundException("KeyBoard was not found ", "KeyBoard was not found with id " + id);
		return e;
	}

	public Long saveKeyBoardToDB(KeyBoard e)   {

		keyboardRepo.save(e);
		return keyboardRepo.findByTag(e.getKeyboardTag()).getId();

	}

	public void updateKeyBoard(Long id, KeyBoard e) throws ModelNotFoundException {
		KeyBoard entry = keyboardRepo.findOne(id);
		if (entry == null)
			throw new ModelNotFoundException("KeyBoard was not found ", "KeyBoard was not found with id " + id);

		entry.copy(e);
		keyboardRepo.update(entry);
	}

	public void deleteKeyBoardById(Long id) throws ModelNotFoundException {

		KeyBoard e = keyboardRepo.findOne(id);

		if (e == null)
			throw new ModelNotFoundException("KeyBoard was not found ", "KeyBoard was not found with id " + id);

		keyboardRepo.delete(e);

	}
}
