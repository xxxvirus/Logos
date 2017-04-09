package ua.com.bookshop.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import ua.com.bookshop.entity.SeriaPub;

public class SeriaDao {

	EntityManagerFactory factory = Persistence
			.createEntityManagerFactory("primary");
	EntityManager manager = factory.createEntityManager();
	
	public void addSeria(String nameS){
		manager.getTransaction().begin();
		SeriaPub spub = new SeriaPub(nameS);
		manager.persist(spub);
		manager.getTransaction().commit();
	}
}
