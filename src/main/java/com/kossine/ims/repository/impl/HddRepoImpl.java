package com.kossine.ims.repository.impl;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.kossine.ims.models.Hdd;
import com.kossine.ims.repository.HddRepo;

@Repository
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class HddRepoImpl extends GenericRepoImpl<Hdd> implements HddRepo {
	public HddRepoImpl() {
		setClazz(Hdd.class);
	}
}