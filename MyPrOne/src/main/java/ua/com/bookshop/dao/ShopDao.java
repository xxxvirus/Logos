package ua.com.bookshop.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import ua.com.bookshop.entity.Book;
import ua.com.bookshop.entity.Category;
import ua.com.bookshop.entity.Languages;
import ua.com.bookshop.entity.SeriaPub;
import ua.com.bookshop.entity.Shop;

public class ShopDao {

	EntityManagerFactory factory = Persistence
			.createEntityManagerFactory("primary");
	EntityManager manager = factory.createEntityManager();

	public void ctreateEl(int year, BigDecimal price, String bookT,
			String nameC, String nameL, String nameS) {
		manager.getTransaction().begin();
		Shop shop = new Shop(year, price);
		manager.persist(shop);
		Shop shopp = (Shop) manager
				.createQuery(
						"select s from Shop s where s.shyear=:year and s.shprice=:price")
				.setParameter("year", year).setParameter("price", price)
				.getSingleResult();
		addEl(shopp, bookT, nameC, nameL, nameS);
		manager.getTransaction().commit();
	}

	public void addEl(Shop shop, String bookT, String nameC, String nameL,
			String nameS) {
		Book book = (Book) manager.createNamedQuery("FindByTitleBooks")
				.setParameter("title", bookT).getSingleResult();
		shop.setShbook(book);
		Category cat = (Category) manager.createNamedQuery("FindByCat")
				.setParameter("name", nameC).getSingleResult();
		shop.setShcat(cat);
		Languages lang = (Languages) manager.createNamedQuery("FindByLnag")
				.setParameter("name", nameL).getSingleResult();
		shop.setShlang(lang);
		SeriaPub spub = (SeriaPub) manager.createNamedQuery("FindBySeria")
				.setParameter("name", nameS).getSingleResult();
		shop.setShSeria(spub);
	}
	
	public List<Shop> apiS(){
		manager.getTransaction().begin();
		CriteriaBuilder cb = manager.getCriteriaBuilder();
		CriteriaQuery<Shop> query = cb.createQuery(Shop.class);
		Root<Shop> root = query.from(Shop.class);
		query.select(root);
		Expression<Integer> priceExp = root.get("shprice");
		Predicate pricePredicate = cb.le(priceExp, new Integer("150"));
//		Join<Shop, Book> bookJoin = root.join("shbook");
//		Expression<String> bookNameExp = bookJoin.get("title");
//		Predicate bookPredicate = cb.like(bookNameExp, "Á%");
//		Predicate all = cb.and(pricePredicate, bookPredicate);
		query.where(pricePredicate);
//		query.where(all);
//		root.fetch("shbook");
		List<Shop> list = manager.createQuery(query).getResultList();
		manager.getTransaction().commit();
		return list;
	}
}
