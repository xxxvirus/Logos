package ua.com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ua.com.shop.entity.Author;
import ua.com.shop.service.AuthorService;
import ua.com.shop.serviceimpl.AuthorServiceImpl;

public class AddAuthorImpl extends HttpServlet {

	static final ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(
			"/META-INF/appContext.xml");

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		AuthorService authorServ = context.getBean(AuthorServiceImpl.class);
		String authorName = req.getParameter("authorName");
		String authorSurname = req.getParameter("authorSurname");
		if (authorServ.selectAuthor(authorName, authorSurname).getName()
				.equalsIgnoreCase(authorName)
				&& authorServ.selectAuthor(authorName, authorSurname)
						.getSurname().equalsIgnoreCase(authorSurname)) {
		} else {
			authorServ.save(new Author(authorName, authorSurname));
		}
		req.getRequestDispatcher("authors.jsp").forward(req, resp);
	}
}
