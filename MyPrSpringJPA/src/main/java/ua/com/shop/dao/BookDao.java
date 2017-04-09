package ua.com.shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.com.shop.entity.Book;

public interface BookDao extends JpaRepository<Book, Integer>{

	@Query("select b from Book b where b.title=:param")
	Book bookName(@Param("param") String bookName);
	
	@Query("select b from Book b join b.author a where a.name=:name and a.surname=:surname")
	Book authorS(@Param("name") String authorName,
			@Param("surname") String authorSurname);
	
}
