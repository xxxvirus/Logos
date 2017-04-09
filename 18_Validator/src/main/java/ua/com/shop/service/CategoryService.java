package ua.com.shop.service;

import java.util.List;

import ua.com.shop.entity.CategoryEnt;

public interface CategoryService {

	void save(CategoryEnt category);
	List<CategoryEnt> findAll();
	CategoryEnt findOne(int id);
	void delete(int id);
	void update(CategoryEnt category);
//	CategoryEnt selectCategory(String categoryName);
	
	CategoryEnt findByName(String nameOfC);
}
