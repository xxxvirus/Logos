package ua.com.shop.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.shop.dao.PublisherDao;
import ua.com.shop.entity.Publisher;
import ua.com.shop.service.PublisherService;

@Service
public class PublisherServiceImpl implements PublisherService{

	@Autowired
	private PublisherDao publisherDao;
	
	public void save(Publisher publisher) {
		publisherDao.save(publisher);
	}

	public List<Publisher> findAll() {
		return publisherDao.findAll();
	}

	public Publisher findOne(int id) {
		return publisherDao.findOne(id);
	}

	public void delete(int id) {
		publisherDao.delete(id);
	}

	public void update(Publisher publisher) {
		publisherDao.save(publisher);
	}

}
