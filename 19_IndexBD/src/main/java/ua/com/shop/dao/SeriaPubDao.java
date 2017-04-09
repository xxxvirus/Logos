package ua.com.shop.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.com.shop.entity.SeriaPub;

public interface SeriaPubDao extends JpaRepository<SeriaPub, Integer>{

	@Query("select sp from SeriaPub sp where sp.nameOfS=:param")
	SeriaPub selectSeria(@Param("param") String seriaName);
	@Query("select sp from SeriaPub sp where sp.publisher.id=?1")
	List<SeriaPub> findByPublisherId(int id);
	@Query("SELECT sp FROM SeriaPub sp LEFT JOIN FETCH sp.publisher WHERE sp.id = ?1")
	SeriaPub findOne(int id);
	
	@Query("select sp from SeriaPub sp where sp.nameOfS=?1 and sp.publisher.id=?2")
	SeriaPub findByUnique(String nameOfS, int publisherId);
}
