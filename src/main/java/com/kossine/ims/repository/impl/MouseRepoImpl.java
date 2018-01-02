package com.kossine.ims.repository.impl;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.kossine.ims.models.Mouse;
import com.kossine.ims.repository.MouseRepo;

@Repository
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class MouseRepoImpl extends GenericRepoImpl<Mouse> implements MouseRepo {
	public MouseRepoImpl() {
		setClazz(Mouse.class);

	}

}
