package ua.com.bookshop.dao;

import ua.com.bookshop.entity.Book;

public class BDaoGen<B> extends Book{

	private B books;

	public BDaoGen(B books) {
		this.books = books;
	}

	public B getBooks() {
		return books;
	}

	public void setBooks(B books) {
		this.books = books;
	}
	
//	public void addBooks()
	
	
}
