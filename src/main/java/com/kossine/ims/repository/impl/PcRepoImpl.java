package com.kossine.ims.repository.impl;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.kossine.ims.models.Pc;
import com.kossine.ims.repository.PcRepo;

@Repository
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class PcRepoImpl extends GenericRepoImpl<Pc> implements PcRepo {

	public PcRepoImpl() {
		setClazz(Pc.class);
	}

}
