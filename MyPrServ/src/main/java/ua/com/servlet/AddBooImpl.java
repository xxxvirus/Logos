package ua.com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ua.com.shop.entity.Author;
import ua.com.shop.entity.Book;
import ua.com.shop.service.AuthorService;
import ua.com.shop.service.BookService;
import ua.com.shop.serviceimpl.AuthorServiceImpl;
import ua.com.shop.serviceimpl.BookServiceImpl;

public class AddBooImpl extends HttpServlet {

	static final ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(
			"/applicationContext.xml");

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		BookService bookServ = context.getBean(BookServiceImpl.class);
//		AuthorService authorServ = context.getBean(AuthorServiceImpl.class);
		String title = req.getParameter("title");
		Integer numbPages = Integer.parseInt(req.getParameter("numbPages"));
		String authorName = req.getParameter("authorName");
		String authorSurname = req.getParameter("authorSurname");
//		Book book = bookServ.selectBook(title, numbPages);
//		Author author = authorServ.selectAuthor(authorName, authorSurname);
//		if (book != null) {
//		} else {
//			bookServ.save(new Book(title, numbPages));
//		}
//		if (author != null) {
//			bookServ.addAuthorToBook(title, numbPages, authorName,
//					authorSurname);
//		} else {
//			authorServ.save(new Author(authorName, authorSurname));
//			bookServ.addAuthorToBook(title, numbPages, authorName,
//					authorSurname);
//		}
		bookServ.createAuthorBook(title, numbPages, authorName, authorSurname);
		req.getRequestDispatcher("book.jsp").forward(req, resp);
	}
}
