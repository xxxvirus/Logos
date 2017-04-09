package ua.com.shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ua.com.shop.entity.TitleShop;

public interface TitleShopDao extends JpaRepository<TitleShop, Integer> {

	@Query("select ts from TitleShop ts where ts.namePub=?1 and ts.book.id=?2")
	TitleShop findByUnique(String namePub, int bookId);
}
