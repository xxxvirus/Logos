package ua.com.shop.service;

import java.util.List;

import ua.com.shop.entity.Book;

public interface BookService {

	void save(Book book);
	List<Book> findAll();
	Book findOne(int id);
	void delete(int id);
	void update(Book book);
//	public Book fetchAuthorBooks(String name);
	Book bookName(String bookName);
	Book authorS(String authorName, String authorSurname);
	void addAuthorToBook(String bookName, String authorName, String authorSurname);
	void delAuthorFromBook(String authorName, String authorSurname);
	
}
