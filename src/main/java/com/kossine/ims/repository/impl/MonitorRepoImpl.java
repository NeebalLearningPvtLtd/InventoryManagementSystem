package com.kossine.ims.repository.impl;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.kossine.ims.models.Monitor;
import com.kossine.ims.repository.MonitorRepo;

@Repository
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class MonitorRepoImpl extends GenericRepoImpl<Monitor> implements MonitorRepo{

	public MonitorRepoImpl() {
		setClazz(Monitor.class);
		
	}

}
