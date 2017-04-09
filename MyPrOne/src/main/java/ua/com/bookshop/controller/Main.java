package ua.com.bookshop.controller;

import java.math.BigDecimal;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import ua.com.bookshop.dao.AuthorDao;
import ua.com.bookshop.dao.BookDao;
import ua.com.bookshop.dao.CategoryDao;
import ua.com.bookshop.dao.LangDao;
import ua.com.bookshop.dao.PubDao;
import ua.com.bookshop.dao.SeriaDao;
import ua.com.bookshop.dao.ShopDao;

public class Main {

	static final Scanner sc = new Scanner(System.in);
	static EntityManagerFactory factory = Persistence
			.createEntityManagerFactory("primary");
	static EntityManager manager = factory.createEntityManager();
	private static BookDao bookDao = new BookDao();
	private static AuthorDao authorDao = new AuthorDao();
	private static CategoryDao catDao = new CategoryDao();
	private static LangDao langDao = new LangDao();
	private static PubDao pubDao = new PubDao();
	private static SeriaDao seraiDao = new SeriaDao();
	private static ShopDao shopDao = new ShopDao();
	
	public static void main(String[] args) {
		while(true){
			System.out.println("1 Book menu");
			System.out.println("2 Author menu");
			switch (sc.next()) {
			case "1":
				bookMenu();
				break;
			case "2":
				authorMenu();
				break;
			case "3":
				categoryMenu();
				break;
			case "4":
				langMenu();
				break;
			case "5":
				pubMenu();
				break;
			case "6":
				seriaPuMenu();
				break;
			case "7":
				shopMenu();
				break;
			default:
				manager.close();
				factory.close();
				return;
			}
		}
	}
	
	private static void shopMenu() {
		System.out.println("Enter year of publishing");
		int year = sc.nextInt();
		System.out.println("Enter price");
		BigDecimal price = sc.nextBigDecimal();
		System.out.println("Enter title of book");
		String bookT = sc.next();
		System.out.println("Enter category of book");
		String nameC = sc.next();
		System.out.println("Enter lang of book");
		String nameL = sc.next();
		System.out.println("Enter seria of book");
		String nameS = sc.next();
		shopDao.ctreateEl(year, price, bookT, nameC, nameL, nameS);
//		System.out.println(shopDao.apiS());
		return;
		
	}

	private static void seriaPuMenu() {
		System.out.println("Enter name of seria");
		String nameS = sc.next();
		seraiDao.addSeria(nameS);
		return;
	}

	private static void pubMenu() {
		System.out.println("Enter name of publisher");
		String nameP = sc.next();
		pubDao.addPub(nameP);;
		return;
	}

	private static void langMenu() {
		System.out.println("Enter lang");
		String langg = sc.next();
		langDao.addLang(langg);
		return;
	}

	private static void categoryMenu() {
		System.out.println("Enter category");
		String categ = sc.next();
		catDao.addCat(categ);
		return;
	}

	public static void authorMenu() {
		while(true){
			System.out.println("Enter 1 to add author");
			System.out.println("Enter 2 to delete author");
			System.out.println("Enter 3 to update author");
			System.out.println("Enter 4 to show all author books");
			switch (sc.next()) {
			case "1":
				System.out.println("Enter author name");
				String authorName = sc.next();
				System.out.println("Enter author surname");
				String authorSurname = sc.next();
				authorDao.addAuthor(authorName, authorSurname);
				break;
			case "2":
				System.out.println("Enter author name");
				String authorName2 = sc.next();
				System.out.println("Enter author surname");
				String authorSurname2 = sc.next();
				authorDao.delAuthor(authorName2, authorSurname2);
				break;
			case "3":
				System.out.println("Enter author name");
				String authorName3 = sc.next();
				System.out.println("Enter author surname");
				String authorSurname3 = sc.next();
				System.out.println("Enter new author name");
				String authorName4 = sc.next();
				System.out.println("Enter new author surname");
				String authorSurname4 = sc.next();
				authorDao.updateAuthor(authorName3, authorSurname3, authorName4, authorSurname4);
				break;
			case "4":
				System.out.println("Enter author name");
				String authorName5 = sc.next();
				System.out.println("Enter author surname");
				String authorSurname5 = sc.next();
				System.out.println(authorDao.showAuthorBooks(authorName5, authorSurname5));
				break;
			default:
				return;
			}
		}
	}

	public static void bookMenu(){
		while(true){
			System.out.println("Enter 1 to add book");
			System.out.println("Enter 2 to delete book");
			System.out.println("Enter 3 to update book");
			System.out.println("Enter 4 to add author to book");
			System.out.println("Enter 5 to show all books");
			System.out.println("Enter 6 to search by title");
			switch (sc.next()) {
			case "1":
				System.out.println("Enter title of book");
				String title = sc.next();
				System.out.println("Enter number of pages");
				int pages = sc.nextInt();
				bookDao.addBook(title, pages);
				break;
			case "2":
				System.out.println("Enter title of book");
				String title2 = sc.next();
				bookDao.delBook(title2);
				break;
			case "3":
				System.out.println("Enter title of book");
				String title3 = sc.next();
				System.out.println("Enter new title of book");
				String title4 = sc.next();
				bookDao.updateBook(title3, title4);
				break;
			case "4":
				System.out.println("Enter author name");
				String authorName = sc.next();
				System.out.println("Enter author surname");
				String authorSurname = sc.next();
				System.out.println("Enter book");
				String title5 = sc.next();
				bookDao.addAuthorToBook(title5, authorName, authorSurname);
				break;
			case "5":
				System.out.println(bookDao.findAll());
				break;
			case "6":
				System.out.println("Enter title of book");
				String titleB = sc.next();
				System.out.println(bookDao.findByTitle(titleB));
				break;
			case "7":
				System.out.println(bookDao.maxPage());
			default:
				return;
			}
		}
	}

}
