package ua.com.shop.daoimplg;

import org.springframework.stereotype.Repository;

import ua.com.shop.daog.AuthorDaoG;
import ua.com.shop.entity.Author;

@Repository
public class AuthorDaoImplG extends GeneralDaoImpl<Author> implements AuthorDaoG{

	public AuthorDaoImplG() {
		super(Author.class);
	}

}
