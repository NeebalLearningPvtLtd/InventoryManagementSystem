package com.kossine.ims.repository;

import java.util.List;

import com.kossine.ims.models.Inventory;

public interface IGenericRepo<T extends Inventory> {

	 T findOne( long id) ;
	 
	 T findByTag(String tag);
	 
	 List<T> findAll();

	 void save( T entity);

	 void update( T entity);

	 void delete( T entity);

	 void deleteById( long entityId) ;
}