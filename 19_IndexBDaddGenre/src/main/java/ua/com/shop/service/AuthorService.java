package ua.com.shop.service;

import java.util.List;

import ua.com.shop.dto.form.AuthorForm;
import ua.com.shop.entity.Author;

public interface AuthorService {

	void save(AuthorForm author);
	List<Author> findAll();
	Author findOne(int id);
	void delete(int id);
	void update(Author author);
	Author selectAuthor(String authorName, String authorSurname);
	void showAuthorBooks(String authorName, String authorSurname);
	Author fetchAuthor(String authorName, String authorSurname);
	
	AuthorForm findForm(int id);
	Author findUnique(String name, String surname, String yearOfBorn, String yearOfDead, String wiki);
}
