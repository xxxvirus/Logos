package ua.com.shop.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.com.shop.dao.BookDao;
import ua.com.shop.dao.GenreDao;
import ua.com.shop.entity.Book;
import ua.com.shop.entity.Genre;
import ua.com.shop.service.GenreService;


@Service
public class GenreServiceImpl implements GenreService {

	@Autowired
	private GenreDao genreDao;
	@Autowired
	private BookDao bookDao;

	@Override
	public void save(Genre genre) {
		genreDao.save(genre);
	}

	@Override
	public List<Genre> findAll() {
		return genreDao.findAll();
	}

	@Override
	public Genre findOne(int id) {
		return genreDao.findOne(id);
	}

	@Override
	public void delete(int id) {
		genreDao.delete(id);
	}

	@Override
	public void update(Genre genre) {
		genreDao.save(genre);
	}

	@Override
	public Genre loadBooks(int id) {
		return genreDao.loadedBook(id);
	}

	@Override
	@Transactional
	public void addBook(int id, int bookId) {
		Genre genre = genreDao.loadedBook(id);
		Book book = bookDao.findOne(bookId);
		genre.getBook().add(book);
		genreDao.save(genre);
	}

	@Override
	@Transactional
	public void deleteBook(int id, int bookId) {
		Genre genre = genreDao.loadedBook(id);
		genre.getBook().removeIf(s -> s.getId() == bookId);
		genreDao.save(genre);
	}

}
