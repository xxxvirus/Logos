package ua.com.bookshop.entity;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Shop {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToMany
	@JoinTable(name="shop_book",
	joinColumns=@JoinColumn(name="id_shop"),
	inverseJoinColumns=@JoinColumn(name="id_book"))
	private List<Book> shbook;
	
	@ManyToMany
	@JoinTable(name="shop_seria",
	joinColumns=@JoinColumn(name="id_shop"),
	inverseJoinColumns=@JoinColumn(name="id_seria"))
	private List<SeriaPub> shSeria;
	
	@ManyToMany
	@JoinTable(name="shop_lang",
	joinColumns=@JoinColumn(name="id_shop"),
	inverseJoinColumns=@JoinColumn(name="id_lang"))
	private List<Languages> shlang;
	
	@ManyToMany
	@JoinTable(name="shop_cat",
	joinColumns=@JoinColumn(name="id_shop"),
	inverseJoinColumns=@JoinColumn(name="id_cat"))
	private List<Category> shcat;
	private int shyear;
	private BigDecimal shprice;
	
	public Shop() {
	}

	public Shop(int shyear, BigDecimal shprice) {
		this.shyear = shyear;
		this.shprice = shprice;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Book> getShbook() {
		return shbook;
	}

	public void setShbook(List<Book> shbook) {
		this.shbook = shbook;
	}

	public List<SeriaPub> getShSeria() {
		return shSeria;
	}

	public void setShSeria(List<SeriaPub> shSeria) {
		this.shSeria = shSeria;
	}

	public List<Languages> getShlang() {
		return shlang;
	}

	public void setShlang(List<Languages> shlang) {
		this.shlang = shlang;
	}

	public List<Category> getShcat() {
		return shcat;
	}

	public void setShcat(List<Category> shcat) {
		this.shcat = shcat;
	}

	public int getShyear() {
		return shyear;
	}

	public void setShyear(int shyear) {
		this.shyear = shyear;
	}

	public BigDecimal getShprice() {
		return shprice;
	}

	public void setShprice(BigDecimal shprice) {
		this.shprice = shprice;
	}

	@Override
	public String toString() {
		return "Shop [id=" + id + ", shyear=" + shyear + ", shprice=" + shprice
				+ "]";
	}
	
}
