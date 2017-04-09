package ua.com.shop.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.com.shop.entity.Book;

public interface BookDao extends JpaRepository<Book, Integer>{

	@Query("select b from Book b where b.title=:param")
	Book bookName(@Param("param") String bookName);
	@Query("select b from Book b where b.pages=:param")
	Book bookPage(@Param("param") Integer pages);
	@Query("select b from Book b where b.title=:param1 and b.pages=:param2")
	Book selectBook(@Param("param1") String title, @Param("param2") Integer pages);
	
	@Query("select b from Book b join b.author a where a.name=:name and a.surname=:surname")
	Book authorS(@Param("name") String authorName,
			@Param("surname") String authorSurname);
	@Query("select b from Book b where b.author.id=?1")
	List<Book> findByAuthorId(int id);
	@Query("select b from Book b left join fetch b.author where b.id=?1")
	Book findOne(int id);
	
}
