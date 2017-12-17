package com.kossine.ims.repository.impl;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kossine.ims.models.Inventory;
import com.kossine.ims.repository.GenericRepo;

@Transactional
@SuppressWarnings("unchecked")
public abstract class GenericRepoImpl<T extends Inventory> implements GenericRepo<T> {

	private static final Logger log = LoggerFactory.getLogger(GenericRepoImpl.class);
	private static final int batchsize = 100;
	protected Class<T> clazz;

	@PersistenceContext
	protected EntityManager em;

	public void setClazz(Class<T> clazzToSet) {
		this.clazz = clazzToSet;
	}

	@Override
	public T findOne(long id) {
		// log.debug("*******trying to fetch enitity ***** "+ clazz.getSimpleName() );
		T t;
		t = em.find(clazz, id);
		// log.debug("Entity fetched "+ t);
		return t;
	}

	public List<T> findAll() {
		return em.createQuery("from " + clazz.getName()).getResultList();
	}

	public void save(T entity) {
		em.persist(entity);
	}

	public void bulkSave(Collection<T> entities) {
		int i = 1;
		for (T entity : entities) {
			// not yet persisted , when mapping from excel
			if (entity.getId() == 0)
				save(entity);
			else
				update(entity);

			if (i % batchsize == 0) {
				em.flush();
				em.clear();
			}

			i++;
		}
		em.flush();
		em.clear();

	}

	public void bulkDelete() {
		// Delete Inventory table and all its dependent tables
	}

	public void update(T entity) {
		em.merge(entity);
	}

	public void delete(T entity) {

		em.remove(entity);
	}

	public void deleteById(long entityId) {
		T entity = findOne(entityId);
		if (entity != null)
			delete(entity);
	}

}
