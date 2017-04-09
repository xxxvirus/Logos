package ua.com.bookshop.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import ua.com.bookshop.entity.Author;
import ua.com.bookshop.entity.Book;

public class AuthorDao {

	EntityManagerFactory factory = Persistence
			.createEntityManagerFactory("primary");
	EntityManager manager = factory.createEntityManager();

	public void addAuthor(String authorName, String authorSurname) {
		manager.getTransaction().begin();
		Author author = new Author(authorName, authorSurname);
		manager.persist(author);
		manager.getTransaction().commit();
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
	}

	@SuppressWarnings("unchecked")
	public List<Book> showAuthorBooks(String name, String surname) {
		manager.getTransaction().begin();
		List<Book> books = manager
				.createQuery("select b from Book b join b.author a where a.name=:name and a.surname=:surname")
				.setParameter("name", name)
				.setParameter("surname", surname)
				.getResultList();
		manager.getTransaction().commit();
		return books;
	}
}
