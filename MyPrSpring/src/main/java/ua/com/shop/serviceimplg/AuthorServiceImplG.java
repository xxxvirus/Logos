package ua.com.shop.serviceimplg;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;

import ua.com.shop.entity.Author;
import ua.com.shop.entity.Book;
import ua.com.shop.serviceg.AuthorServiceG;

@Service
public class AuthorServiceImplG extends GeneralServiceImpl<Author> implements AuthorServiceG {

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;
	
	@SuppressWarnings("unchecked")
	public List<Book> showAuthorBooks(String name, String surname) {
		List<Book> books = manager
				.createQuery("select b from Book b join b.author a where a.name=:name and a.surname=:surname")
				.setParameter("name", name)
				.setParameter("surname", surname)
				.getResultList();
		return books;
	}

}
