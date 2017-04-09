package ua.com.shop.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class TitleShop {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String namePub;

	@ManyToOne
	private Book book;
	@OneToMany(mappedBy = "titleSh")
	private List<Shop> shops;

	public TitleShop() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNamePub() {
		return namePub;
	}

	public void setNamePub(String namePub) {
		this.namePub = namePub;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public List<Shop> getShops() {
		return shops;
	}

	public void setShops(List<Shop> shops) {
		this.shops = shops;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((book == null) ? 0 : book.hashCode());
		result = prime * result + id;
		result = prime * result + ((namePub == null) ? 0 : namePub.hashCode());
		result = prime * result + ((shops == null) ? 0 : shops.hashCode());
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
		TitleShop other = (TitleShop) obj;
		if (book == null) {
			if (other.book != null)
				return false;
		} else if (!book.equals(other.book))
			return false;
		if (id != other.id)
			return false;
		if (namePub == null) {
			if (other.namePub != null)
				return false;
		} else if (!namePub.equals(other.namePub))
			return false;
		if (shops == null) {
			if (other.shops != null)
				return false;
		} else if (!shops.equals(other.shops))
			return false;
		return true;
	}

}
