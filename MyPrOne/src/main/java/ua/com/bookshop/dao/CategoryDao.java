package ua.com.bookshop.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import ua.com.bookshop.entity.Category;

public class CategoryDao {

	EntityManagerFactory factory = Persistence
			.createEntityManagerFactory("primary");
	EntityManager manager = factory.createEntityManager();
	
	public void addCat(String name){
		manager.getTransaction().begin();
		Category cat = new Category(name);
		manager.persist(cat);
		manager.getTransaction().commit();
	}
}
