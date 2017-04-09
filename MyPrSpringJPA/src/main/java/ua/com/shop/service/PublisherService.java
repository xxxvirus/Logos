package ua.com.shop.service;

import java.util.List;

import ua.com.shop.entity.Publisher;

public interface PublisherService {

	void save(Publisher publisher);
	List<Publisher> findAll();
	Publisher findOne(int id);
	void delete(int id);
	void update(Publisher publisher);
}
