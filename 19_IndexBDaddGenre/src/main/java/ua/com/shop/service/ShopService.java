package ua.com.shop.service;

import java.math.BigDecimal;
import java.util.List;

import ua.com.shop.dto.form.ShopForm;
import ua.com.shop.entity.Category;
import ua.com.shop.entity.Languages;
import ua.com.shop.entity.SeriaPub;
import ua.com.shop.entity.Shop;
import ua.com.shop.entity.TitleShop;

public interface ShopService {

	void save(ShopForm shop);
	List<Shop> findAll();
	Shop findOne(int id);
	void delete(int id);
	void update(Shop shop);
//	void addEl(int year, BigDecimal price, String bookT, String nameC,
//			String nameL, String nameS);
	
	Shop selectShop(BigDecimal price, int year, int id);
	List<Shop> findByCategoryId(int id);
//	List<Shop> findByBookId(int id);
	List<Shop> findByPublisherId(int id);
	
	ShopForm findForm(int id);
	Shop findUnique(String shyear, String shprice, String isbn, String edition,
			String page, TitleShop titleShop, SeriaPub seriaPub, Languages lang,
			Category category);
}
