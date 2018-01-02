package com.kossine.ims.repository.impl;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.kossine.ims.models.PowerSupply;
import com.kossine.ims.repository.PowerSupplyRepo;
@Repository
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class PowerSupplyRepoImpl extends GenericRepoImpl<PowerSupply> implements PowerSupplyRepo{
	public PowerSupplyRepoImpl() {
		setClazz(PowerSupply.class);
		
	}
	

}
