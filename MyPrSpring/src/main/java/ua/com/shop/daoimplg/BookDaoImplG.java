package ua.com.shop.daoimplg;

import org.springframework.stereotype.Repository;

import ua.com.shop.daog.BookDaoG;
import ua.com.shop.entity.Book;

@Repository
public class BookDaoImplG extends GeneralDaoImpl<Book> implements BookDaoG {

	public BookDaoImplG() {
		super(Book.class);
	}

}
