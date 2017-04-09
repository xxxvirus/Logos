package ua.com.shop.service;

import java.util.List;

import ua.com.shop.entity.SeriaPub;

public interface SeriaPubService {

	void save(SeriaPub seriaPub);
	List<SeriaPub> findAll();
	SeriaPub findOne(int id);
	void delete(int id);
	void update(SeriaPub seriaPub);
	SeriaPub selectSeria(String seriaNmae);
}
