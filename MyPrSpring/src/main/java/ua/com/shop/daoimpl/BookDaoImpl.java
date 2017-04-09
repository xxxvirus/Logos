package ua.com.shop.daoimpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ua.com.shop.dao.BookDao;
import ua.com.shop.entity.Author;
import ua.com.shop.entity.Book;

@Repository
public class BookDaoImpl implements BookDao {

	@PersistenceContext(unitName="primary")
	protected EntityManager manager;
	
	public EntityManager getManager() {
		return manager;
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	@Transactional
	public void save(Book book) {
		manager.persist(book);
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Book> findAll() {
		return manager.createQuery("from Book").getResultList();
	}

	@Transactional
	public Book findOne(int id) {
		return manager.find(Book.class, id);
	}

	@Transactional
	public void delete(int id) {
		manager.remove(id);
	}
	
	@Transactional
	public void addAuthorToBook(String bookName, String authorName,
			String authorSurname) {
//		manager.getTransaction().begin();
		Author author = (Author) manager
				.createQuery(
						"select a from Author a where a.name =:param and a.surname =:param2")
				.setParameter("param", authorName)
				.setParameter("param2", authorSurname).getSingleResult();
		Book book = (Book) manager
				.createQuery("select b from Book b where b.title =:param")
				.setParameter("param", bookName).getSingleResult();
		book.setAuthor(author);
//		manager.merge(book);
//		manager.getTransaction().commit();
	}

}
