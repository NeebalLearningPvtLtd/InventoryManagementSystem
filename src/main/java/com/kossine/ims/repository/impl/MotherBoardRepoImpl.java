package com.kossine.ims.repository.impl;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.kossine.ims.models.MotherBoard;
import com.kossine.ims.repository.MotherBoardRepo;
@Repository
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class MotherBoardRepoImpl extends GenericRepoImpl<MotherBoard> implements MotherBoardRepo{

	public MotherBoardRepoImpl() {
		setClazz(MotherBoard.class);
		
	}

}
