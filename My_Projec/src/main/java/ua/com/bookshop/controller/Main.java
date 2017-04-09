package ua.com.bookshop.controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import ua.com.bookshop.dao.AuthorDao;
import ua.com.bookshop.dao.BookDao;

public class Main {

	static final Scanner sc = new Scanner(System.in);
	static EntityManagerFactory factory = Persistence
			.createEntityManagerFactory("primary");
	static EntityManager manager = factory.createEntityManager();
	private static BookDao bookDao = new BookDao();
	private static AuthorDao authorDao = new AuthorDao();
	
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
			case "0":
				return;
			default:
				break;
			}
		}
		

	}
	
	public static void authorMenu() {
		while(true){
			System.out.println("Enter 1 to add author");
			System.out.println("Enter 2 to delete author");
			System.out.println("Enter 3 to update author");
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
			default:
				return;
			}
		}
	}

}
