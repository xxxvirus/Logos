package ua.com.bookshop.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@NamedQueries({
	
	@NamedQuery(name = "FindAllBooks", query = "from Book"),
	@NamedQuery(name = "FindByTitleBooks", query = "select b from Book b where b.title=:title"),
	@NamedQuery(name = "FindByPagesBooks", query = "select b from Book b where b.pages=:page")
	
})

@Entity
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String title;
	private int pages;
	@ManyToOne
	private Author author;
	
	@OneToMany(mappedBy="shbook")
	private List<Shop> shop;
	
	public Book() {
	}

	public Book(String title, int pages) {
		super();
		this.title = title;
		this.pages = pages;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public List<Shop> getShop() {
		return shop;
	}

	public void setShop(List<Shop> shop) {
		this.shop = shop;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", pages=" + pages + "]";
	}

}
