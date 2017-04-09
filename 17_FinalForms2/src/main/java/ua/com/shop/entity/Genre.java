package ua.com.shop.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Genre {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nameOfG;
	
	@ManyToMany
	@JoinTable(name="book_genre",
	joinColumns=@JoinColumn(name="id_genre"),
	inverseJoinColumns=@JoinColumn(name="id_book"))
	private List<Book> book;

	public Genre() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNameOfG() {
		return nameOfG;
	}

	public void setNameOfG(String nameOfG) {
		this.nameOfG = nameOfG;
	}

	public List<Book> getBook() {
		return book;
	}

	public void setBook(List<Book> book) {
		this.book = book;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((book == null) ? 0 : book.hashCode());
		result = prime * result + id;
		result = prime * result + ((nameOfG == null) ? 0 : nameOfG.hashCode());
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
		Genre other = (Genre) obj;
		if (book == null) {
			if (other.book != null)
				return false;
		} else if (!book.equals(other.book))
			return false;
		if (id != other.id)
			return false;
		if (nameOfG == null) {
			if (other.nameOfG != null)
				return false;
		} else if (!nameOfG.equals(other.nameOfG))
			return false;
		return true;
	}

	
}
