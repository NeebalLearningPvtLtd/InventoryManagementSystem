package com.kossine.ims.repository;

import java.util.List;

import com.kossine.ims.models.Laptop;


public interface LaptopRepo extends GenericRepo<Laptop> {
	List<Laptop> findByTagLikeQuery(String laptoptag);
}
