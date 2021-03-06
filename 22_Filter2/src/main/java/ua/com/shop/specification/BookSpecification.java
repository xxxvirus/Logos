package ua.com.shop.specification;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import ua.com.shop.dto.filter.BookFilter;
import ua.com.shop.entity.Book;

public class BookSpecification implements Specification<Book> {

	private final BookFilter filter;
	private final List<Predicate> predicates = new ArrayList<>();
	
	public BookSpecification(BookFilter filter) {
		this.filter = filter;
	}
	
	private void filterByGenres(Root<Book> root, CriteriaQuery<?> query, CriteriaBuilder cb){
		if(!filter.getGenrIds().isEmpty()){
			predicates.add(root.get("genre").in(filter.getGenrIds()));
		}
	}
	
	private void fetch(Root<Book> root, CriteriaQuery<?> query){
		if(!query.getResultType().equals(Long.class)){
			query.distinct(true);
			root.fetch("genre");
		}
	}
	
	@Override
	public Predicate toPredicate(Root<Book> root, CriteriaQuery<?> query,
			CriteriaBuilder cb) {
		fetch(root, query);
		filterByGenres(root, query, cb);
		if(predicates.isEmpty()) return null;
		Predicate[] array = new Predicate[predicates.size()];
		array = predicates.toArray(array);
		return cb.and(array);
	}

}
