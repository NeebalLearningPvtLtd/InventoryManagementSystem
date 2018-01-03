package com.kossine.ims.repository.impl;

import java.util.List;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.kossine.ims.models.Pc;
import com.kossine.ims.repository.PcRepo;

@Repository
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class PcRepoImpl extends GenericRepoImpl<Pc> implements PcRepo {

	public PcRepoImpl() {
		setClazz(Pc.class);
	}

	@SuppressWarnings("unchecked")
	public List<Pc> findAllWithJoin(Pageable pageable) {

		return em.createNamedQuery("Pc.findAllWithJoin").setFirstResult(pageable.getOffset())
				.setMaxResults(pageable.getPageSize()).getResultList();

	}
}
