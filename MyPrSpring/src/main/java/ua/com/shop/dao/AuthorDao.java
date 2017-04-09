package ua.com.shop.dao;

import java.util.List;

import ua.com.shop.entity.Author;

public interface AuthorDao {

	void save(Author author);
	List<Author> findAll();
	Author findOne(int id);
	void delete(int id);
}
