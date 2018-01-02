package com.kossine.ims.repository.impl;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.kossine.ims.models.Wifi;
import com.kossine.ims.repository.WifiRepo;
@Repository
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class WifiRepoImpl extends GenericRepoImpl<Wifi> implements WifiRepo{
	public WifiRepoImpl() {
		setClazz(Wifi.class);
		
	}
	

}
