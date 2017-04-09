package ua.com.shop.serviceg;

import java.util.List;

public interface GeneralService<K> {

	void save(K entity);
	List<K> findAll();
	K findOne(int id);
	void delete(int id);
}
