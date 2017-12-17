package com.kossine.ims.repository;

import java.util.List;

import com.kossine.ims.models.Adapter;

public interface AdapterRepo extends GenericRepo<Adapter> {

	List<Adapter> findByTagLikeQuery(String adaptertag);

}
