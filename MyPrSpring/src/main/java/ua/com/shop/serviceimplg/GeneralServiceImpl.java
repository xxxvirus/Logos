package ua.com.shop.serviceimplg;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ua.com.shop.daog.GeneralDao;
import ua.com.shop.serviceg.GeneralService;

public abstract class GeneralServiceImpl<K> implements GeneralService<K> {

	@Autowired
	private GeneralDao<K> general;
	
	public void save(K entity) {
		general.save(entity);
	}

	public List<K> findAll() {
		return general.findAll();
	}

	public K findOne(int id) {
		return general.findOne(id);
	}

	public void delete(int id) {
		general.delete(id);
	}

}
