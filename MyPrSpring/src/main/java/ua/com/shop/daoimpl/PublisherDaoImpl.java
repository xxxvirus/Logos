package ua.com.shop.daoimpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ua.com.shop.dao.PublisherDao;
import ua.com.shop.entity.Publisher;

@Repository
public class PublisherDaoImpl implements PublisherDao{

	@PersistenceContext(unitName="primary")
	private EntityManager manager;

	@Transactional
	public void save(Publisher publisher) {
		manager.persist(publisher);
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Publisher> findAll() {
		return manager.createQuery("from Publisher").getResultList();
	}

	@Transactional
	public Publisher findOne(int id) {
//		return (Publisher) manager.createQuery("select p from p Publisher where p.id = :name").setParameter("id", id).getSingleResult();
		return manager.find(Publisher.class, id);
	}

	@Transactional
	public void delete(int id) {
		manager.remove(id);
	}
}
