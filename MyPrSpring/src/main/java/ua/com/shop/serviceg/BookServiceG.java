package ua.com.shop.serviceg;

import ua.com.shop.entity.Book;

public interface BookServiceG extends GeneralService<Book> {

	public void addAuthorToBook(String bookName, String authorName,
			String authorSurname);
	public void delAuthor(String authorName, String authorSurname);
}
