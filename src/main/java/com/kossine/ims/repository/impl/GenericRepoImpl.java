package com.kossine.ims.repository.impl;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;

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
		log.debug("Trying to fetch enitity  " + clazz.getSimpleName() + " with id : " + id);
		T result = null;
		try {
			result = em.find(clazz, id);
		} catch (IllegalArgumentException e) {
			log.warn("Illegal argument for findOne " + e);
			log.debug("Entity was not fetched with id : " + id);
		}
		if (result != null)
			log.debug("Entity fetched " + result.getId());
		return result;
	}

	public T findByTag(String tag) {

		T result = null;
		log.debug("Trying to fetch enitity  " + clazz.getSimpleName() + " with tag : " + tag);

		try {
			result = (T) em.createNamedQuery(clazz.getSimpleName() + ".getByTag").setParameter("tag", tag)
					.getSingleResult();
		} catch (NoResultException e) {
			log.debug("No entity was found for  " + clazz.getSimpleName() + " with tag : " + tag);
		}
		if (result != null)
			log.debug("Entity fetched " + result);
		return result;

	}

	public List<T> findAll(Pageable pageable) {

		return em.createQuery("from " + clazz.getName()).setFirstResult(pageable.getOffset())
				.setMaxResults(pageable.getPageSize()).getResultList();
	}

	public void save(T entity) {
		if (entity == null)
			return;

		log.debug("trying to save " + clazz.getSimpleName() + " id : " + entity.getId());

		em.persist(entity);
		log.debug("entity saved id : " + entity.getId());

	}

	public void bulkSave(Collection<T> entities) {
		log.debug("Trying bulk saving for " + clazz.getSimpleName());

		int i = 1;
		for (T entity : entities) {
			if (entity == null)
				continue;
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
		log.debug("bulk saving finished for  " + clazz.getSimpleName());
	}

	public void bulkDelete() {
		// Delete Inventory table and all its dependent tables
	}

	public void update(T entity) {
		if (entity == null)
			return;
		log.debug("trying to update " + clazz.getSimpleName() + " id : " + entity.getId());

		try {
			em.merge(entity);
			log.debug("entity updated id : " + entity.getId());
		} catch (IllegalArgumentException ex) {
			log.warn("updating of entity :" + clazz.getSimpleName() + " failed " + ex);
		}

		log.debug("entity updated with id : " + entity.getId());

	}

	public void delete(T entity) {
		if (entity == null)
			return;
		log.debug("trying to delete entity " + clazz.getSimpleName() + " id : " + entity.getId());
		try {

			em.remove(entity);

		} catch (IllegalArgumentException e) {

			log.warn("enitity was not deleted " + e);
		}
		log.debug("entity deleted with id : " + entity.getId());
	}

	public void deleteById(long entityId) {
		T entity = findOne(entityId);
		if (entity != null)
			delete(entity);
	}

}
