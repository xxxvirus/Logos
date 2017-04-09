package ua.com.bookshop.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import ua.com.bookshop.entity.Author;
import ua.com.bookshop.entity.Book;

public class GenDao {

	EntityManagerFactory factory = Persistence
			.createEntityManagerFactory("primary");
	EntityManager manager = factory.createEntityManager();
	
	private static Book book = new Book();
	private static Author author = new Author();
	BDaoGen<Book> bookDao = new BDaoGen<Book>(book);
	ADaoGen<Author> authorkDao = new ADaoGen<Author>(author);
	
	public void add(GenDao a){
		manager.getTransaction().begin();
		manager.getTransaction().commit();
		manager.close();
		factory.close();
	}
}
