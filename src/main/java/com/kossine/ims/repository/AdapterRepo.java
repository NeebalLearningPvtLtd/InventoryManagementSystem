package com.kossine.ims.repository;

import com.kossine.ims.models.Adapter;

public class AdapterRepo extends GenericDao<Adapter> implements IAdapterRepo{
	public AdapterRepo() {
		this.clazz=Adapter.class;
	}

}
