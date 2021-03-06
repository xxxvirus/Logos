package ua.com.shop.dao;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.com.shop.dto.filter.ShopFilter;
import ua.com.shop.entity.Shop;
import ua.com.shop.specification.ShopSpecification;

public interface ShopDao extends JpaRepository<Shop, Integer>, JpaSpecificationExecutor<Shop> {

	@Query("select sh from Shop sh where sh.shprice=:param and sh.shyear=:param1 and sh.id=:id")
	Shop selectShop(@Param("param") BigDecimal price,
			@Param("param1") int year, @Param("id") int id);

	@Query("select s from Shop s where s.shcat.id=?1")
	List<Shop> findByCategoryId(int id);

	// @Query("select s from Shop s where s.shbook.id=?1")
	// List<Shop> findByBookId(int id);

	@Query("select s from Shop s where s.shSeria.publisher.id=?1")
	List<Shop> findByPublisherId(int id);

	@Query("select s from Shop s left join fetch s.titleSh left join fetch s.shcat left join fetch s.shlang left join fetch s.shSeria where s.id=?1")
	Shop findOne(int id);

	@Query("select s from Shop s where s.shyear=?1 and s.shprice=?2 and s.isbn=?3 and s.edition=?4 and s.shpage=?5 and s.titleSh.id=?6 and s.shSeria.id=?7 and s.shlang.id=?8 and s.shcat.id=?9")
	Shop findUnique(int shyear, BigDecimal shprice, String isbn, int edition,
			int shpage, int titleShopId, int seriaPubId, int langId,
			int categoryId);
//	@Query("select s from Shop s where s.titleSh.book.author.id=?1")
//	Page<Shop> findByAuthorId(int id);
	
//	@Query("select s from Shop s where s.titleSh.book.author.id=?1")
//	Page<Shop> findByAuthorIdd(int id, Page<Shop> findAll(Pageable pageable, ShopFilter filter));

}
