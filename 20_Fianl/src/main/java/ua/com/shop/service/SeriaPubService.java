package ua.com.shop.service;

import java.util.List;

import ua.com.shop.entity.SeriaPub;

public interface SeriaPubService {

	void save(SeriaPub seriaPub);
	List<SeriaPub> findAll();
	SeriaPub findOne(int id);
	void delete(int id);
	void update(SeriaPub seriaPub);
	
//	public void createPublisherAndSeria(String seriaName, String nameOfP);
	
	SeriaPub selectSeria(String seriaName);
	List<SeriaPub> findByPublisherId(int id);
	SeriaPub findByUnique(String nameOfS, int publisherId);
}
