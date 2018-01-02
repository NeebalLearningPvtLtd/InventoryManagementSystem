package com.kossine.ims.repository.impl;

import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.kossine.ims.models.Laptop;
import com.kossine.ims.repository.LaptopRepo;

@Repository
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class LaptopRepoImpl extends GenericRepoImpl<Laptop> implements LaptopRepo {
	public LaptopRepoImpl() {
		setClazz(Laptop.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Laptop> findByTagLikeQuery(String laptopTag) {
		try {
			return (List<Laptop>) em.createNamedQuery("getByLaptopTagLikeQuery")
					.setParameter("laptopTag", "%" + laptopTag + "%").getResultList();
		} catch (NoResultException e) {
			return null;
		}
	}
}
