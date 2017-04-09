package ua.com.shop.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String surname;
	private int yearOfBorn;
	private int yearOfDead;
	private String wiki;
	@OneToMany(mappedBy="author")
	private List<Book> books;
	
	public Author() {
	}

	public Author(String name, String surname) {
		this.name = name;
		this.surname = surname;
	}
	
	public Author(String name, String surname, int yearOfBorn, int yearOfDead, String wiki) {
		this.name = name;
		this.surname = surname;
		this.yearOfBorn = yearOfBorn;
		this.yearOfDead = yearOfDead;
		this.wiki = wiki;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public int getYearOfBorn() {
		return yearOfBorn;
	}

	public void setYearOfBorn(int yearOfBorn) {
		this.yearOfBorn = yearOfBorn;
	}

	public String getWiki() {
		return wiki;
	}

	public void setWiki(String wiki) {
		this.wiki = wiki;
	}

	public int getYearOfDead() {
		return yearOfDead;
	}

	public void setYearOfDead(int yearOfDead) {
		this.yearOfDead = yearOfDead;
	}
	
	
	

//	@Override
//	public String toString() {
//		return "Author [id=" + id + ", name=" + name + ", surname=" + surname
//				+ "]";
//	}
	
}
