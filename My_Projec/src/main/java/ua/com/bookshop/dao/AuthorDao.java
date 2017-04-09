package ua.com.bookshop.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import ua.com.bookshop.entity.Author;

public class AuthorDao {

	EntityManagerFactory factory = Persistence
			.createEntityManagerFactory("primary");
	EntityManager manager = factory.createEntityManager();

	public void addAuthor(String authorName, String authorSurname) {
		manager.getTransaction().begin();
		Author author = new Author(authorName, authorSurname);
		manager.persist(author);
		manager.getTransaction().commit();
		manager.close();
		factory.close();
	}

	public void updateAuthor(String oldauthorName, String oldauthorSurname,
			String authorName, String authorSurname) {
		manager.getTransaction().begin();
		Author author = (Author) manager
				.createQuery(
						"select a from Author a where a.name =:param and a.surname =:param2")
				.setParameter("param", oldauthorName)
				.setParameter("param2", oldauthorSurname).getSingleResult();
		author.setName(authorName);
		author.setSurname(authorSurname);
		manager.getTransaction().commit();
		manager.close();
		factory.close();
	}

	public void delAuthor(String authorName, String authorSurname) {
		manager.getTransaction().begin();
		Author author = (Author) manager
				.createQuery(
						"select a from Author a where a.name =:param and a.surname =:param2")
				.setParameter("param", authorName)
				.setParameter("param2", authorSurname).getSingleResult();
		manager.remove(author);
		manager.getTransaction().commit();
		manager.close();
		factory.close();
	}
}
