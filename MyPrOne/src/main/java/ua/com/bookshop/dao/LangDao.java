package ua.com.bookshop.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import ua.com.bookshop.entity.Languages;

public class LangDao {

	EntityManagerFactory factory = Persistence
			.createEntityManagerFactory("primary");
	EntityManager manager = factory.createEntityManager();
	
	public void addLang(String lang){
		manager.getTransaction().begin();
		Languages language = new Languages(lang);
		manager.persist(language);
		manager.getTransaction().commit();
	}
}
