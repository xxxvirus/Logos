package ua.com.shop.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.shop.dao.CategoryDao;
import ua.com.shop.entity.CategoryEnt;
import ua.com.shop.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryDao categoryDao;
	
	public void save(CategoryEnt category) {
		categoryDao.save(category);
	}

	public List<CategoryEnt> findAll() {
		return categoryDao.findAll();
	}

	public CategoryEnt findOne(int id) {
		return categoryDao.findOne(id);
	}

	public void delete(int id) {
		categoryDao.delete(id);
	}

	public void update(CategoryEnt category) {
		categoryDao.save(category);
	}

//	@Override
//	public CategoryEnt selectCategory(String categoryName) {
//		return categoryDao.selectCategory(categoryName);
//	}

	@Override
	public CategoryEnt findByName(String nameOfC) {
		return categoryDao.findByName(nameOfC);
	}

}
