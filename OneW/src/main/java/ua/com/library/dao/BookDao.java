package ua.com.library.dao;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import ua.com.library.entity.Book;

public class BookDao {

	static final Scanner sc = new Scanner(System.in);

	EntityManagerFactory factory = Persistence
			.createEntityManagerFactory("primary");
	EntityManager manager = factory.createEntityManager();

	public void save(Book book) {
		manager.getTransaction().begin();
		manager.persist(book);
		manager.getTransaction().commit();
	}

	public List<Book> findAll() {
		return manager.createQuery("from Book").getResultList();
	}

	public void addBook() {
		System.out.println("Enter title");
		String title = sc.next();
		System.out.println("Enter number of pages");
		int pages = sc.nextInt();
		Book book = new Book(title, pages);
		save(book);
	}

	public void delBook() {
		manager.getTransaction().begin();
		System.out.println("Enter title of book");
		String title = sc.next();
		Book book = (Book) manager
				.createQuery("select b from Book b where b.title =:name")
				.setParameter("name", title).getSingleResult();
		manager.remove(book);
		manager.getTransaction().commit();
	}

	public void updateBook() {
		manager.getTransaction().begin();
		System.out.println("Enter title of book");
		String title = sc.next();
		System.out.println("Enter new title of book");
		String newTitle = sc.next();
		Book book = (Book) manager
				.createQuery("select b from Book b where b.title =:name")
				.setParameter("name", title).getSingleResult();
		book.setTitle(newTitle);
		manager.getTransaction().commit();
	}

}
