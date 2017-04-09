package ua.com.bookshop.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Languages {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String lang;
	
	@ManyToMany
	@JoinTable(name="shop_lang",
	joinColumns=@JoinColumn(name="id_lang"),
	inverseJoinColumns=@JoinColumn(name="id_shop"))
	private List<Shop> shop;

	public Languages() {
	}

	public Languages(String lang) {
		this.lang = lang;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public List<Shop> getShop() {
		return shop;
	}

	public void setShop(List<Shop> shop) {
		this.shop = shop;
	}

	@Override
	public String toString() {
		return "Languages [id=" + id + ", lang=" + lang + "]";
	}
	
}
