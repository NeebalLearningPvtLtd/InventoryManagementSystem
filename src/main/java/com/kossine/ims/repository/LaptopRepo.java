package com.kossine.ims.repository;

import javax.persistence.Query;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.kossine.ims.models.Laptop;

@Repository
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class LaptopRepo extends GenericRepo<Laptop> implements ILaptopRepo {
	public LaptopRepo() {
		setClazz(Laptop.class);
	}
	
	
	public Laptop findByTag(String laptopTag) {

		Query query = entityManager.createNamedQuery("getByLaptopTag");
		query.setParameter("laptopTag", laptopTag);
		return (Laptop) query.getSingleResult();
	}
}
