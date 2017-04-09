package ua.com.shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.com.shop.entity.Publisher;

public interface PublisherDao extends JpaRepository<Publisher, Integer>{

	@Query("select p from Publisher p where p.name=:param")
	Publisher selectPublisher(@Param("param") String nameOfP);
}
