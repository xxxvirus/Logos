package ua.com.shop.daog;

import java.util.List;

public interface GeneralDao<K> {

	void save(K entity);
	List<K> findAll();
	K findOne(int id);
	void delete(int id);
	
}
