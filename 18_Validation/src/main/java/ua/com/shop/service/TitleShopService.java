package ua.com.shop.service;

import java.util.List;

import ua.com.shop.entity.TitleShop;

public interface TitleShopService {

	void save(TitleShop titleSh);
	List<TitleShop> findAll();
	TitleShop findOne(int id);
	void delete(int id);
	void update(TitleShop titleSh);
	
	TitleShop findByUnique(String namePub, int bookId);
}
