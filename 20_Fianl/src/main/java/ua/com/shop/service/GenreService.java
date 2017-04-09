package ua.com.shop.service;

import java.util.List;

import ua.com.shop.entity.Genre;

public interface GenreService {

	void save(Genre genre);
	List<Genre> findAll();
	Genre findOne(int id);
	void delete(int id);
	void update(Genre genre);
	
	void addBook(int id, int bookId);
	Genre loadBooks(int id);
	void deleteBook(int id, int bookId);
	List<Genre> findAll(List<Integer> collect);
	Genre findByName(String nameOfG);
}
