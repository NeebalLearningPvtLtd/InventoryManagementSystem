package com.kossine.ims.repository.impl;

import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.kossine.ims.models.Adapter;
import com.kossine.ims.repository.AdapterRepo;

@Repository
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class AdapterRepoImpl extends GenericRepoImpl<Adapter> implements AdapterRepo {
	public AdapterRepoImpl() {
		setClazz(Adapter.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Adapter> findByTagLikeQuery(String adaptertag) {
		try {
			return (List<Adapter>) em.createNamedQuery("getByAdapterTagLikeQuery")
					.setParameter("adapterTag", "%" + adaptertag + "%").getResultList();
		} catch (NoResultException e) {
			return null;
		}
	}

}
