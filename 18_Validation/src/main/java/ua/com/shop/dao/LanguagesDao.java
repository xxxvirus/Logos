package ua.com.shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.com.shop.entity.Languages;

public interface LanguagesDao extends JpaRepository<Languages, Integer>{

	@Query("select l from Languages l where l.lang=:param")
	Languages selectLang(@Param("param") String langName);
	@Query("select l from Languages l where l.lang=:param")
	Languages findByName(@Param("param") String name);
}
