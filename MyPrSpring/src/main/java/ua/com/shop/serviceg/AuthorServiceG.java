package ua.com.shop.serviceg;

import java.util.List;

import ua.com.shop.entity.Author;
import ua.com.shop.entity.Book;

public interface AuthorServiceG extends GeneralService<Author>{

	List<Book> showAuthorBooks(String name, String surname);
}
