package ua.com.shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.com.shop.entity.CategoryEnt;

public interface CategoryDao extends JpaRepository<CategoryEnt, Integer>{

//	@Query("select c from Category c where c.nameOfC=:param")
//	CategoryEnt selectCategory(@Param("param") String categoryName);
	@Query("select c from CategoryEnt c where c.nameOfC=:param")
	CategoryEnt findByName(@Param("param") String nameOfC);
}
