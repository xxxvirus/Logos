package ua.com.shop.dao;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.com.shop.entity.Shop;

public interface ShopDao extends JpaRepository<Shop, Integer>{

	@Query("select sh from Shop sh where sh.shprice=:param and sh.shyear=:param1 and sh.id=:id")
	Shop selectShop(@Param("param") BigDecimal price, @Param("param1") int year, @Param("id") int id);
}
