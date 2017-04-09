package ua.com.shop.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@NamedQueries({
	
	@NamedQuery(name = "FindByCat", query = "select c from Category c where c.nameOfC=:name"),
	
})

@Entity
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nameOfC;
	@OneToMany(mappedBy="shcat")
	private List<Shop> shop;
	
	public Category() {
	}
	
	public Category(String nameOfC) {
		this.nameOfC = nameOfC;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNameOfC() {
		return nameOfC;
	}

	public void setNameOfC(String nameOfC) {
		this.nameOfC = nameOfC;
	}
	
	public List<Shop> getShop() {
		return shop;
	}

	public void setShop(List<Shop> shop) {
		this.shop = shop;
	}

//	@Override
//	public String toString() {
//		return "Category [id=" + id + ", nameOfC=" + nameOfC + "]";
//	}
	
}
