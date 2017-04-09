package ua.com.shop.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.shop.dao.AuthorDao;
import ua.com.shop.dao.BookDao;
import ua.com.shop.entity.Author;
import ua.com.shop.entity.Book;
import ua.com.shop.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookDao bookDao;

	@Autowired
	private AuthorDao authorDao;

	public void save(Book book) {
		bookDao.save(book);
	}

	public List<Book> findAll() {
		return bookDao.findAll();
	}

	public Book findOne(int id) {
		return bookDao.findOne(id);
	}

	public void delete(int id) {
		bookDao.delete(id);
	}

	public void update(Book book) {
		bookDao.save(book);
	}

	public Book bookName(String bookName) {
		return bookDao.bookName(bookName);
	}

	public void addAuthorToBook(String bookName, String authorName,
			String authorSurname) {
		Author author = authorDao.selectAuthor(authorName, authorSurname);
		Book book = bookDao.bookName(bookName);
		book.setAuthor(author);
		bookDao.save(book);
	}

	public void delAuthorFromBook(String authorName, String authorSurname) {
		Book book = bookDao.authorS(authorName, authorSurname);
		book.setAuthor(null);
		bookDao.save(book);
	}

	public Book authorS(String authorName, String authorSurname) {
		return bookDao.authorS(authorName, authorSurname);
	}

}
