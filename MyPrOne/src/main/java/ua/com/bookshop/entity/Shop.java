package ua.com.bookshop.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Shop {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	private Book shbook;
	
	@ManyToOne
	private SeriaPub shSeria;
	
	@ManyToOne
	private Languages shlang;
	
	@ManyToOne
	private Category shcat;
	
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

	public Book getShbook() {
		return shbook;
	}

	public void setShbook(Book shbook) {
		this.shbook = shbook;
	}

	public SeriaPub getShSeria() {
		return shSeria;
	}

	public void setShSeria(SeriaPub shSeria) {
		this.shSeria = shSeria;
	}

	public Languages getShlang() {
		return shlang;
	}

	public void setShlang(Languages shlang) {
		this.shlang = shlang;
	}

	public Category getShcat() {
		return shcat;
	}

	public void setShcat(Category shcat) {
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
