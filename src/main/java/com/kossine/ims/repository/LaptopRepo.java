package com.kossine.ims.repository;

import com.kossine.ims.models.Laptop;

public class LaptopRepo extends GenericDao<Laptop> implements ILaptopRepo {
	public LaptopRepo() {
		setClazz(Laptop.class);
	}
}
