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
	Book bookPage(Integer pages);
	Book authorS(String authorName, String authorSurname);
	Book selectBook(String title, Integer pages);
	void addAuthorToBook(String bookName, Integer pages, String authorName, String authorSurname);
	void createAuthorBook(String title, Integer pages, String authorName, String authorSurname);
	void delAuthorFromBook(String authorName, String authorSurname);
	List<Book> findByAuthorId(int id);
	
}
