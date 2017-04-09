package ua.com.bookshop.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import ua.com.bookshop.entity.Publisher;

public class PubDao {

	EntityManagerFactory factory = Persistence
			.createEntityManagerFactory("primary");
	EntityManager manager = factory.createEntityManager();
	
	public void addPub(String nameP){
		manager.getTransaction().begin();
		Publisher publ = new Publisher(nameP);
		manager.persist(publ);
		manager.getTransaction().commit();
	}
}
