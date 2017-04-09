package ua.com.bookshop.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class SeriaPub {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nameOfS;
	@ManyToOne
	private Publisher publisher;
	
	@ManyToMany
	@JoinTable(name="shop_seria",
	joinColumns=@JoinColumn(name="id_seria"),
	inverseJoinColumns=@JoinColumn(name="id_shop"))
	private List<Shop> shop;

	public SeriaPub() {
	}

	public SeriaPub(String nameOfS) {
		this.nameOfS = nameOfS;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNameOfS() {
		return nameOfS;
	}

	public void setNameOfS(String nameOfS) {
		this.nameOfS = nameOfS;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	public List<Shop> getShop() {
		return shop;
	}

	public void setShop(List<Shop> shop) {
		this.shop = shop;
	}

	@Override
	public String toString() {
		return "SeriaPub [id=" + id + ", nameOfS=" + nameOfS + "]";
	}
	
}
