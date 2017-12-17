package com.kossine.ims.repository.impl;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

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

	@Override
	public Laptop findByTag(String laptopTag) {

		Query query = em.createNamedQuery("getByLaptopTag");
		query.setParameter("laptopTag", laptopTag);

		Laptop result = null;
		try {
			result = (Laptop) query.getSingleResult();
		} catch (NoResultException e) {

		}
		return result;
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
