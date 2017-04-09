package ua.com.shop.dao;

import java.util.List;

import ua.com.shop.entity.Publisher;

public interface PublisherDao {

	void save(Publisher publisher);
	List<Publisher> findAll();
	Publisher findOne(int id);
	void delete(int id);
}
