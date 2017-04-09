package ua.com.shop.service;

import java.util.List;

import ua.com.shop.entity.Category;

public interface CategoryService {

	void save(Category category);
	List<Category> findAll();
	Category findOne(int id);
	void delete(int id);
	void update(Category category);
	Category selectCategory(String categoryName);
	Category findByName(String name);
}
