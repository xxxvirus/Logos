package ua.com.shop.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.shop.dao.AuthorDao;
import ua.com.shop.dao.BookDao;
import ua.com.shop.dto.form.AuthorForm;
import ua.com.shop.entity.Author;
import ua.com.shop.entity.Book;
import ua.com.shop.service.AuthorService;

@Service
public class AuthorServiceImpl implements AuthorService {

	@Autowired
	private AuthorDao authorDao;
	@Autowired
	private BookDao bookDao;
	
	public void save(Author author) {
		authorDao.save(author);
	}

	public List<Author> findAll() {
		return authorDao.findAll();
	}

	public Author findOne(int id) {
		return authorDao.findOne(id);
	}

	public void delete(int id) {
		authorDao.delete(id);
	}

	public void update(Author author) {
		authorDao.save(author);
	}

	public Author selectAuthor(String authorName, String authorSurname) {
		return authorDao.selectAuthor(authorName, authorSurname);
	}

	@Override
	public void showAuthorBooks(String authorName, String authorSurname) {
		Author author = authorDao.fetchAuthor(authorName, authorSurname);
		for (Book book : author.getBooks()) {
			System.out.println(book);
		}
	}

	@Override
	public Author fetchAuthor(String authorName, String authorSurname) {
		return authorDao.fetchAuthor(authorName, authorSurname);
	}

	@Override
	public void save(AuthorForm form) {
		Author author = new Author();
		author.setId(form.getId());
		author.setName(form.getName());
		author.setSurname(form.getSurname());
		author.setYearOfBorn(Integer.valueOf(form.getYearOfBorn()));
		author.setYearOfDead(Integer.valueOf(form.getYearOfDead()));
		author.setWiki(form.getWiki());
		authorDao.save(author);
	}

	@Override
	public AuthorForm findForm(int id) {
		AuthorForm form = new AuthorForm();
		Author author = authorDao.findOne(id);
		form.setId(author.getId());
		form.setName(author.getName());
		form.setSurname(author.getSurname());
		form.setYearOfBorn(String.valueOf(author.getYearOfBorn()));
		form.setYearOfDead(String.valueOf(author.getYearOfDead()));
		form.setWiki(author.getWiki());
		return form;
	}

	@Override
	public Author findUnique(String name, String surname, String yearOfBorn,
			String yearOfDead, String wiki) {
		return authorDao.findUnique(name, surname, Integer.valueOf(yearOfBorn), Integer.valueOf(yearOfDead), wiki);
	}


}
