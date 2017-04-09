package ua.com.shop.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.shop.dao.CategoryDao;
import ua.com.shop.entity.Category;
import ua.com.shop.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryDao categoryDao;
	
	public void save(Category category) {
		categoryDao.save(category);
	}

	public List<Category> findAll() {
		return categoryDao.findAll();
	}

	public Category findOne(int id) {
		return categoryDao.findOne(id);
	}

	public void delete(int id) {
		categoryDao.delete(id);
	}

	public void update(Category category) {
		categoryDao.save(category);
	}

	@Override
	public Category selectCategory(String categoryName) {
		return categoryDao.selectCategory(categoryName);
	}

}
