package com.kossine.ims.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.domain.Pageable;

import com.kossine.ims.models.Inventory;

public interface GenericRepo<T extends Inventory> {

	T findOne(long id);

	T findByTag(String tag);

	List<T> findAll(Pageable pageable);

	void save(T entity);

	void bulkSave(Collection<T> entities);

	void bulkDelete();

	void update(T entity);

	void delete(T entity);

	void deleteById(long entityId);
}