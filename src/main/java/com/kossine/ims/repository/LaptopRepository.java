package com.kossine.ims.repository;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.kossine.ims.models.Laptop;


@Repository
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class LaptopRepository extends GenericDao<Laptop> implements ILaptopRepository{
	public LaptopRepository() {
	setClazz(Laptop.class);
	}
}
