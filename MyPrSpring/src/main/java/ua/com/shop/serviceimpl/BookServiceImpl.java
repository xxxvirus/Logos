package ua.com.shop.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.shop.dao.BookDao;
import ua.com.shop.entity.Book;
import ua.com.shop.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookDao bookDao;
	
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

	public void addAuthorToBook(String bookName, String authorName,
			String authorSurname) {
		bookDao.
		
	}
}
