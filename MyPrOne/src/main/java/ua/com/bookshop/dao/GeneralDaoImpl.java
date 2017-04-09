package ua.com.bookshop.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class GeneralDaoImpl<K> implements GeneralDao<K>{

	private Class<K> entityClass;
	@PersistenceContext(unitName="primary")
	EntityManager em;
	
	public GeneralDaoImpl(Class<K> entityClass) {
		super();
		this.entityClass = entityClass;
	}

	public K create (K entity){
		em.persist(entity);
		return entity;
	}
}
