package ua.com.shop.dao;

import java.util.List;

import ua.com.shop.entity.Book;

public interface BookDao {

	void save(Book book);
	List<Book> findAll();
	Book findOne(int id);
	void delete(int id);
	void addAuthorToBook(String bookName, String authorName,
			String authorSurname);
}
