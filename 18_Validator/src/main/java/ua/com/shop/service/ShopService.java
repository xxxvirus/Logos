package ua.com.shop.service;

import java.math.BigDecimal;
import java.util.List;

import ua.com.shop.entity.Shop;

public interface ShopService {

	void save(Shop shop);
	List<Shop> findAll();
	Shop findOne(int id);
	void delete(int id);
	void update(Shop shop);
//	void addEl(int year, BigDecimal price, String bookT, String nameC,
//			String nameL, String nameS);
	
	Shop selectShop(BigDecimal price, int year, int id);
//	List<Shop> findByCategoryId(int id);
	List<Shop> findByBookId(int id);
	List<Shop> findByPublisherId(int id);
}
