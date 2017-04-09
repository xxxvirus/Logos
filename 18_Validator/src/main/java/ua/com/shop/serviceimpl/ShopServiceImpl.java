package ua.com.shop.serviceimpl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.shop.dao.BookDao;
import ua.com.shop.dao.CategoryDao;
import ua.com.shop.dao.LanguagesDao;
import ua.com.shop.dao.SeriaPubDao;
import ua.com.shop.dao.ShopDao;
import ua.com.shop.entity.Shop;
import ua.com.shop.service.ShopService;

@Service
public class ShopServiceImpl implements ShopService {

	@Autowired
	private ShopDao shopDao;
	@Autowired
	private BookDao bookDao;
	@Autowired
	private CategoryDao categoryDao;
	@Autowired
	private LanguagesDao langDao;
	@Autowired
	private SeriaPubDao seriaPubDao;
	
	public void save(Shop shop) {
		shopDao.save(shop);
	}

	public List<Shop> findAll() {
		return shopDao.findAll();
	}

	public Shop findOne(int id) {
		return shopDao.findOne(id);
	}

	public void delete(int id) {
		shopDao.delete(id);
	}

	public void update(Shop shop) {
		shopDao.save(shop);
	}

//	@Override
//	public void addEl(int year, BigDecimal price, String bookT, String nameC, String nameL,
//			String nameS) {
//		Shop shop = new Shop(year, price);
//		shopDao.save(shop);
//		int id = shop.getId();
//		Shop shopp = shopDao.selectShop(price, year, id);
//		Book book = bookDao.bookName(bookT);
//		shopp.setShbook(book);
//		Category category = categoryDao.selectCategory(nameC);
//		shopp.setShcat(category);
//		Languages lang = langDao.selectLang(nameL);
//		shopp.setShlang(lang);
//		SeriaPub seria = seriaPubDao.selectSeria(nameS);
//		shopp.setShSeria(seria);
//		shopDao.save(shopp);
//	}

	@Override
	public Shop selectShop(BigDecimal price, int year, int id) {
		return shopDao.selectShop(price, year, id);
	}

//	@Override
//	public List<Shop> findByCategoryId(int id) {
//		return shopDao.findByCategoryId(id);
//	}

	@Override
	public List<Shop> findByBookId(int id) {
		return shopDao.findByBookId(id);
	}

	@Override
	public List<Shop> findByPublisherId(int id) {
		return shopDao.findByPublisherId(id);
	}


}
