package ua.com.shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.com.shop.entity.Publisher;

public interface PublisherDao extends JpaRepository<Publisher, Integer>{

	
}
