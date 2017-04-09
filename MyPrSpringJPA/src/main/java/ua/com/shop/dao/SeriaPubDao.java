package ua.com.shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.com.shop.entity.SeriaPub;

public interface SeriaPubDao extends JpaRepository<SeriaPub, Integer>{

	@Query("select sp from SeriaPub sp where sp.nameOfS=:param")
	SeriaPub selectSeria(@Param("param") String seriaNmae);
}
