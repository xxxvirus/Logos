package ua.com.shop.daoimplg;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import ua.com.shop.daog.GeneralDao;

public abstract class GeneralDaoImpl<K> implements GeneralDao<K> {

	private Class<K> entityClass;
	
	@PersistenceContext(unitName = "primary")
	private EntityManager manager;
	
	public GeneralDaoImpl(Class<K> entityClass) {
		this.entityClass = entityClass;
	}

	public GeneralDaoImpl(Class<K> entityClass, EntityManager manager) {
		super();
		this.entityClass = entityClass;
		this.manager = manager;
	}
	
	public EntityManager getManager() {
		return manager;
	}

	@PersistenceContext
	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	@Transactional
	public void save(K entity) {
		manager.persist(entity);
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<K> findAll() {
		return manager.createQuery("from " + entityClass.getSimpleName())
				.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public K findOne(int id) {
		return (K) manager
				.createQuery(
						"select k from " + entityClass.getSimpleName()
								+ " k where k.id=:param")
				.setParameter("param", id).getSingleResult();
	}

	@Transactional
	public void delete(int id) {
		manager.remove(id);
	}

}
