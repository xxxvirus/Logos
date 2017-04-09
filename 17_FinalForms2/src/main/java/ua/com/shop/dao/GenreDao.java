package ua.com.shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.com.shop.entity.Genre;

public interface GenreDao extends JpaRepository<Genre, Integer> {

	@Query("SELECT DISTINCT g FROM Genre g LEFT JOIN FETCH g.book WHERE "
			+ "g.id=:id")
	Genre loadedBook(@Param("id")int id);
}
