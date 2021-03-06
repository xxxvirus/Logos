package ua.com.shop.controller;

import java.math.BigDecimal;
import java.util.Scanner;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ua.com.shop.entity.Author;
import ua.com.shop.entity.Book;
import ua.com.shop.entity.Category;
import ua.com.shop.entity.Languages;
import ua.com.shop.entity.Publisher;
import ua.com.shop.entity.SeriaPub;
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

public class Main {

	static final Scanner sc = new Scanner(System.in);
	static final ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(
			"/META-INF/appContext.xml");

	public static void main(String[] args) {

		while (true) {
			System.out.println("Enter 1 to BookMenu");
			System.out.println("Enter 2 to AuthorMenu");
			switch (sc.next()) {
			case "1":
				bookMenu();
				break;
			case "2":
				authorMenu();
				break;
			case "3":
				shopMenu();
				break;
			case "4":
				CategoryService catServ = context
						.getBean(CategoryServiceImpl.class);
				catServ.save(new Category("XX"));
				LanguagesService langServ = context
						.getBean(LanguagesServiceImpl.class);
				langServ.save(new Languages("ukr"));
				PublisherService pubServ = context
						.getBean(PublisherServiceImpl.class);
				pubServ.save(new Publisher("Folio"));
				SeriaPubService sPubServ = context
						.getBean(SeriaPubServiceImpl.class);
				sPubServ.save(new SeriaPub("Classic"));
				break;
			default:
				context.close();
			}
		}
	}

	private static void shopMenu() {
		ShopService shopServ = context.getBean(ShopServiceImpl.class);
		while (true) {
			System.out.println("Enter 1 to add product");
			switch (sc.next()) {
			case "1":
				System.out.println("Enter title of book");
				String bookName = sc.next();
				System.out.println("Enter seria of Publisher");
				String SeriaPub = sc.next();
				System.out.println("Enter lang of book");
				String nameL = sc.next();
				System.out.println("Enter year of publishing");
				int year = sc.nextInt();
				System.out.println("Enter category");
				String category = sc.next();
				System.out.println("Enter price");
				BigDecimal price = sc.nextBigDecimal();
				shopServ.addEl(year, price, bookName, category, nameL, SeriaPub);
				return;

			default:
				break;
			}
		}
	}

	private static void authorMenu() {
		AuthorService authorServ = context.getBean(AuthorServiceImpl.class);
		while (true) {
			System.out.println("Enter 1 to add author");
			System.out.println("Enter 2 to show all author books");
			switch (sc.next()) {
			case "1":
				System.out.println("Enter author name");
				String authorName = sc.next();
				System.out.println("Enter author surname");
				String authorSurname = sc.next();
				authorServ.save(new Author(authorName, authorSurname));
				return;
			case "2":
				System.out.println("Enter author name");
				String authorName1 = sc.next();
				System.out.println("Enter author surname");
				String authorSurname1 = sc.next();
				authorServ.showAuthorBooks(authorName1, authorSurname1);
				return;
			case "3":
				System.out.println(authorServ.findAll());
				return;
			default:
				break;
			}
		}
	}

	private static void bookMenu() {
		BookService bookServ = context.getBean(BookServiceImpl.class);
		while (true) {
			System.out.println("Enter 1 to add book");
			System.out.println("Enter 2 to add author to book");
			System.out.println("Enter 3 to show all books");
			switch (sc.next()) {
			case "1":
				System.out.println("Enter title of book");
				String bookName = sc.next();
				System.out.println("Enter number of pages");
				int page = sc.nextInt();
				bookServ.save(new Book(bookName, page));
				return;
			case "2":
				System.out.println("Enter book name");
				String bookName1 = sc.next();
				System.out.println("Enter author name");
				String authorName = sc.next();
				System.out.println("Enter author surname");
				String authorSurname = sc.next();
				bookServ.addAuthorToBook(bookName1, authorName, authorSurname);
				return;
			case "3":
				System.out.println(bookServ.findAll());
				return;
			default:
				return;
			}
		}
	}

}
