package ua.com.shop.serviceimplg;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.shop.daog.BookDaoG;
import ua.com.shop.entity.Author;
import ua.com.shop.entity.Book;
import ua.com.shop.serviceg.BookServiceG;

@Service
public class BookServiceImplG extends GeneralServiceImpl<Book> implements BookServiceG {
	
	@Autowired
	private BookDaoG bookDao;
	
	private EntityManager manager;

	public void addAuthorToBook(String bookName, String authorName,
			String authorSurname) {
		bookDao.
//		manager.getTransaction().begin();
		Author author = (Author) manager
				.createQuery(
						"select a from Author a where a.name =:param and a.surname =:param2")
				.setParameter("param", authorName)
				.setParameter("param2", authorSurname).getSingleResult();
		Book book = (Book) manager
				.createQuery("select b from Book b where b.title =:param")
				.setParameter("param", bookName).getSingleResult();
		book.setAuthor(author);
//		manager.merge(book);
//		manager.getTransaction().commit();
	}

	public void delAuthor(String authorName, String authorSurname) {
		Author author = (Author) manager
				.createQuery(
						"select a from Author a where a.name =:param and a.surname =:param2")
				.setParameter("param", authorName)
				.setParameter("param2", authorSurname).getSingleResult();
		for (Book book : author.getBooks()) {
			book.setAuthor(null);
			manager.merge(book);
		}
		
	}
	
	

	
}
