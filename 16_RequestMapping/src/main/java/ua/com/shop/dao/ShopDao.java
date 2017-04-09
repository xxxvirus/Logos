package ua.com.shop.dao;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.com.shop.entity.Shop;

public interface ShopDao extends JpaRepository<Shop, Integer>{

	@Query("select sh from Shop sh where sh.shprice=:param and sh.shyear=:param1 and sh.id=:id")
	Shop selectShop(@Param("param") BigDecimal price, @Param("param1") int year, @Param("id") int id);
	@Query("select s from Shop s where s.shcat.id=?1")
	List<Shop> findByCategoryId(int id);
	@Query("select s from Shop s where s.shbook.id=?1")
	List<Shop> findByBookId(int id);
	@Query("select s from Shop s where s.shSeria.publisher.id=?1")
	List<Shop> findByPublisherId(int id);


}
