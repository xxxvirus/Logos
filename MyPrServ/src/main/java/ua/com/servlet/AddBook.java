package ua.com.servlet;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ua.com.shop.entity.Author;
import ua.com.shop.entity.Book;
import ua.com.shop.entity.Category;
import ua.com.shop.entity.Languages;
import ua.com.shop.entity.Publisher;
import ua.com.shop.entity.SeriaPub;
import ua.com.shop.entity.Shop;
import ua.com.shop.service.AuthorService;
import ua.com.shop.service.BookService;
import ua.com.shop.service.CategoryService;
import ua.com.shop.service.LanguagesService;
import ua.com.shop.service.PublisherService;
import ua.com.shop.service.SeriaPubService;
import ua.com.shop.service.ShopService;
import ua.com.shop.serviceimpl.AuthorServiceImpl;
import ua.com.shop.serviceimpl.BookServiceImpl;
import ua.com.shop.serviceimpl.CategoryServiceImpl;
import ua.com.shop.serviceimpl.LanguagesServiceImpl;
import ua.com.shop.serviceimpl.PublisherServiceImpl;
import ua.com.shop.serviceimpl.SeriaPubServiceImpl;
import ua.com.shop.serviceimpl.ShopServiceImpl;

public class AddBook extends HttpServlet{

//	static final ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(
//			"/META-INF/appContext.xml");
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
//		CategoryService catServ = context
//				.getBean(CategoryServiceImpl.class);
//		LanguagesService langServ = context
//				.getBean(LanguagesServiceImpl.class);
//		PublisherService pubServ = context
//				.getBean(PublisherServiceImpl.class);
//		SeriaPubService sPubServ = context
//				.getBean(SeriaPubServiceImpl.class);
//		AuthorService authorServ = context.getBean(AuthorServiceImpl.class);
//		BookService bookServ = context.getBean(BookServiceImpl.class);
//		ShopService shopServ = context.getBean(ShopServiceImpl.class);
//		String title = req.getParameter("title");
//		String authorName = req.getParameter("authorName");
//		String authorSurname = req.getParameter("authorSurname");
//		String publisher = req.getParameter("publisher");
//		String seriaOfPub = req.getParameter("seriaOfPub");
//		int numbPages = Integer.parseInt(req.getParameter("numbPages"));
//		int yearOfPub = Integer.parseInt(req.getParameter("yearOfPub"));
//		String langOfBook = req.getParameter("langOfBook");
//		String categoryOfBook = req.getParameter("categoryOfBook");
//		BigDecimal price = new BigDecimal(req.getParameter("price"));
//		bookServ.update(new Book(title, numbPages));
//		bookServ.addAuthorToBook(title, authorName, authorSurname);
//		authorServ.update(new Author(authorName, authorSurname));
//		pubServ.update(new Publisher(publisher));
//		sPubServ.update(new SeriaPub(seriaOfPub));
//		langServ.update(new Languages(langOfBook));
//		catServ.update(new Category(categoryOfBook));
//		shopServ.update(new Shop(yearOfPub, price));
//		shopServ.addEl(yearOfPub, price, title, categoryOfBook, langOfBook, seriaOfPub);
		req.getRequestDispatcher("books.jsp").forward(req, resp);
	}
	
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
//			throws ServletException, IOException {
//		CategoryService catServ = context
//				.getBean(CategoryServiceImpl.class);
//		LanguagesService langServ = context
//				.getBean(LanguagesServiceImpl.class);
//		PublisherService pubServ = context
//				.getBean(PublisherServiceImpl.class);
//		SeriaPubService sPubServ = context
//				.getBean(SeriaPubServiceImpl.class);
//		AuthorService authorServ = context.getBean(AuthorServiceImpl.class);
//		BookService bookServ = context.getBean(BookServiceImpl.class);
//		ShopService shopServ = context.getBean(ShopServiceImpl.class);
//		String title = req.getParameter("title");
//		String authorName = req.getParameter("authorName");
//		String authorSurname = req.getParameter("authorSurname");
//		String publisher = req.getParameter("publisher");
//		String seriaOfPub = req.getParameter("seriaOfPub");
//		int numbPages = Integer.parseInt(req.getParameter("numbPages"));
//		int yearOfPub = Integer.parseInt(req.getParameter("yearOfPub"));
//		String langOfBook = req.getParameter("langOfBook");
//		String categoryOfBook = req.getParameter("categoryOfBook");
//		BigDecimal price = new BigDecimal(req.getParameter("price"));
//		bookServ.update(new Book(title, numbPages));
//		bookServ.addAuthorToBook(title, authorName, authorSurname);
//		authorServ.update(new Author(authorName, authorSurname));
//		pubServ.update(new Publisher(publisher));
//		sPubServ.update(new SeriaPub(seriaOfPub));
//		langServ.update(new Languages(langOfBook));
//		catServ.update(new Category(categoryOfBook));
//		shopServ.update(new Shop(yearOfPub, price));
//		shopServ.addEl(yearOfPub, price, title, categoryOfBook, langOfBook, seriaOfPub);
//		req.getRequestDispatcher("books.jsp").forward(req, resp);
//	}
}
