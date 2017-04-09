package ua.com.shop.daoimpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ua.com.shop.dao.AuthorDao;
import ua.com.shop.entity.Author;

@Repository
public class AuthorDaoImpl implements AuthorDao {

	@PersistenceContext(unitName="primary")
	private EntityManager manager;
	
	@Transactional
	public void save(Author author) {
		manager.persist(author);
		
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Author> findAll() {
		return manager.createQuery("from Author").getResultList();
	}

	@Transactional
	public Author findOne(int id) {
		return manager.find(Author.class, id);
	}

	@Transactional
	public void delete(int id) {
		manager.remove(id);
	}

}
