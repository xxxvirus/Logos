package ua.com.shop.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.com.shop.dto.filter.ShopFilter;
import ua.com.shop.dto.form.ShopForm;
import ua.com.shop.dto.rest.ShopDto;
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
	List<ShopDto> findByAuthorId(int id);
	List<ShopDto> findAllDto();
	
	
	ShopForm findForm(int id);
	Shop findUnique(String shyear, String shprice, String isbn, String edition,
			String shpage, TitleShop titleShop, SeriaPub seriaPub, Languages lang,
			Category category);
//	Page<Shop> findByAuthor(int id, Pageable pageable, ShopFilter filter);
	Page<Shop> findAll(Pageable pageable, ShopFilter filter);
//	Page<Shop> findAll(int id, Pageable pageable, ShopFilter filter);
//	Page<Shop> findByAuthor(int id, Pageable pageable, ShopFilter filter);
}
