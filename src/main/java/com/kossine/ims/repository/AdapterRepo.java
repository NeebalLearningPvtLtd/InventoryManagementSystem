package com.kossine.ims.repository;

import javax.persistence.Query;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.kossine.ims.models.Adapter;
@Repository
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class AdapterRepo extends GenericRepo<Adapter> implements IAdapterRepo{
	public AdapterRepo() {
		this.clazz=Adapter.class;
	}

	@Override
	public Adapter findByTag(String adapterTag) {
		Query query = entityManager.createNamedQuery("getByAdapterTag");
		query.setParameter("adapterTag", adapterTag);
		return (Adapter) query.getSingleResult();
	}

}
