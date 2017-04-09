package ua.com.shop.service;

import java.util.List;

import ua.com.shop.entity.Author;

public interface AuthorService {

	void save(Author author);
	List<Author> findAll();
	Author findOne(int id);
	void delete(int id);
}
