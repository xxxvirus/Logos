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

public class SomeServlet extends HttpServlet{
	static final ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(
			"/META-INF/appContext.xml");
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		AuthorService authorServ = context.getBean(AuthorServiceImpl.class);
		String name = req.getParameter("some");
		String surname = req.getParameter("some1");
		authorServ.save(new Author(name, surname));
//		System.out.println(req.getParameter("some")+" "+req.getParameter("some1"));
		req.getRequestDispatcher("home.jsp").forward(req, resp);
	}
}
