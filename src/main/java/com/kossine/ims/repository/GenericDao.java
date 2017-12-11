package com.kossine.ims.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kossine.ims.models.Inventory;

@Transactional
@SuppressWarnings("unchecked")
public abstract class GenericDao<T extends Inventory> implements IGenericDao<T> {

	private static final Logger log = LoggerFactory.getLogger(GenericDao.class);

	protected Class<T> clazz;

	@PersistenceContext
	protected EntityManager entityManager;
 
	public void setClazz(Class<T> clazzToSet) {
		this.clazz = clazzToSet;
	}

	@Override
	public T findOne(long id) throws Exception{
		T t;
		try {
		 t=entityManager.find(clazz, id);
		}
		catch(Exception e) {
			
			throw new Exception("database  down");
			
		}
	 return t; 
	}


	public List<T> findAll() {
		return entityManager.createQuery("from " + clazz.getName()).getResultList();
	}

	public void save(T entity) {
		entityManager.persist(entity);
	}

	public void update(T entity) {
		entityManager.merge(entity);
	}

	public void delete(T entity) {
		
		entityManager.remove(entity);
	}

	public void deleteById(long entityId) throws Exception{
		T entity = findOne(entityId);
		delete(entity);
	}
}
