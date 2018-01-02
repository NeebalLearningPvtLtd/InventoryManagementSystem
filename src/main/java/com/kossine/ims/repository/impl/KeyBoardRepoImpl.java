package com.kossine.ims.repository.impl;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.kossine.ims.models.KeyBoard;
import com.kossine.ims.repository.KeyBoardRepo;

@Repository
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class KeyBoardRepoImpl extends GenericRepoImpl<KeyBoard> implements KeyBoardRepo {
	public KeyBoardRepoImpl() {
		setClazz(KeyBoard.class);
	}
}