package ua.com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ua.com.shop.service.SeriaPubService;
import ua.com.shop.serviceimpl.SeriaPubServiceImpl;

public class AddPublisherImpl extends HttpServlet {

	static final ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(
			"/META-INF/appContext.xml");
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		SeriaPubService sPubServ = context
				.getBean(SeriaPubServiceImpl.class);
		String publisher = req.getParameter("publisher");
		String seriaOfPub = req.getParameter("seriaOfPub");
		sPubServ.createPublisherAndSeria(seriaOfPub, publisher);
		req.getRequestDispatcher("publisher.jsp").forward(req, resp);
	}
}
