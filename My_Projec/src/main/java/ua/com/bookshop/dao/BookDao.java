package ua.com.bookshop.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import ua.com.bookshop.entity.Author;
import ua.com.bookshop.entity.Book;

public class BookDao {

	EntityManagerFactory factory = Persistence
			.createEntityManagerFactory("primary");
	EntityManager manager = factory.createEntityManager();

	public List<Book> findAll() {
		return manager.createQuery("from Book").getResultList();
	}

	public Book finOne(String title) {
		Book book = (Book) manager
				.createQuery("select b from Book b where b.title =:param")
				.setParameter("param", title).getSingleResult();
		return book;

	}

	public void addBook(String title, int pages) {
		manager.getTransaction().begin();
		Book book = new Book(title, pages);
		manager.persist(book);
		manager.getTransaction().commit();
		manager.close();
		factory.close();
	}

	public void delBook(String title) {
		manager.getTransaction().begin();
		manager.remove(finOne(title));
		manager.getTransaction().commit();
		manager.close();
		factory.close();
	}

	public void updateBook(String title, String newTitle) {
		manager.getTransaction().begin();
		Book book = (Book) manager
				.createQuery("select b from Book b where b.title = :name")
				.setParameter("name", title).getSingleResult();
		book.setTitle(newTitle);
		manager.getTransaction().commit();
		manager.close();
		factory.close();
	}

	public void addAuthorToBook(String bookName, String authorName,
			String authorSurname) {
		manager.getTransaction().begin();
		Author author = (Author) manager
				.createQuery(
						"select a from Author a where a.name =:param and a.surname =:param2")
				.setParameter("param", authorName).setParameter("param2", authorSurname)
				.getSingleResult();
		Book book = (Book) manager
				.createQuery("select b from Book b where b.title =:param")
				.setParameter("param", bookName).getSingleResult();
		book.setAuthor(author);
		manager.getTransaction().commit();
		manager.close();
		factory.close();
	}
}
