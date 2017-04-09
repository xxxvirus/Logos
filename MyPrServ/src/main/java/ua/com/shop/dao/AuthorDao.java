package ua.com.shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.com.shop.entity.Author;

public interface AuthorDao extends JpaRepository<Author, Integer> {

	@Query("select a from Author a where a.name=:param and a.surname=:param1")
	Author selectAuthor(@Param("param") String authorName,
			@Param("param1") String authorSurname);
	@Query("select a from Author a left join fetch a.books where a.name=:param and a.surname=:param1")
	Author fetchAuthor(@Param("param") String authorName, @Param("param1") String authorSurname);
	
}
