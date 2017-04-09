package ua.com.shop.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Book{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String title;
	private int firstpub;
	@ManyToOne
	private Author author;
	
	@OneToMany(mappedBy="book")
	private List<TitleShop> titleshops;
	
	public Book() {
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

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public int getFirstpub() {
		return firstpub;
	}

	public void setFirstpub(int firstpub) {
		this.firstpub = firstpub;
	}
	

	public List<TitleShop> getTitleshops() {
		return titleshops;
	}

	public void setTitleshops(List<TitleShop> titleshops) {
		this.titleshops = titleshops;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + firstpub;
		result = prime * result + id;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result
				+ ((titleshops == null) ? 0 : titleshops.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (firstpub != other.firstpub)
			return false;
		if (id != other.id)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (titleshops == null) {
			if (other.titleshops != null)
				return false;
		} else if (!titleshops.equals(other.titleshops))
			return false;
		return true;
	}
	
}
