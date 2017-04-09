package ua.com.shop.controller;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ua.com.shop.serviceg.BookServiceG;
import ua.com.shop.serviceimplg.BookServiceImplG;

public class Main {

	public static void main(String[] args) {

		ConfigurableApplicationContext context =
				new ClassPathXmlApplicationContext("/META-INF/appContext.xml");
//		AuthorServiceG authorServ = context.getBean(AuthorServiceImplG.class);
//		bookServ.addAuthorToBook("Mirables", "Victor", "Hugo");
//		bookServ.addAuthorToBook("Less", "Adam", "Johnson");
//		System.out.println(authorServ.showAuthorBooks("Marcel", "Prust"));
		BookServiceG bookServ = context.getBean(BookServiceImplG.class);
//		bookServ.delAuthor("Marcel", "Prust");
		bookServ.addAuthorToBook("Limit", "Adam", "Johnson");
		context.close();
	}

}
