package ua.com.shop.entity;

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
	private TitleShop titleSh;
	
	@ManyToOne
	private SeriaPub shSeria;
	
	@ManyToOne
	private Languages shlang;
	
	@ManyToOne
	private Category shcat;
	
	private int shyear;
	private BigDecimal shprice;
	private String isbn;
	private int edition;
	private int page;
	
	public Shop() {
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public TitleShop getTitleSh() {
		return titleSh;
	}

	public void setTitleSh(TitleShop titleSh) {
		this.titleSh = titleSh;
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

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public int getEdition() {
		return edition;
	}

	public void setEdition(int edition) {
		this.edition = edition;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + edition;
		result = prime * result + id;
		result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
		result = prime * result + page;
		result = prime * result + ((shSeria == null) ? 0 : shSeria.hashCode());
		result = prime * result + ((shcat == null) ? 0 : shcat.hashCode());
		result = prime * result + ((shlang == null) ? 0 : shlang.hashCode());
		result = prime * result + ((shprice == null) ? 0 : shprice.hashCode());
		result = prime * result + shyear;
		result = prime * result + ((titleSh == null) ? 0 : titleSh.hashCode());
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
		Shop other = (Shop) obj;
		if (edition != other.edition)
			return false;
		if (id != other.id)
			return false;
		if (isbn == null) {
			if (other.isbn != null)
				return false;
		} else if (!isbn.equals(other.isbn))
			return false;
		if (page != other.page)
			return false;
		if (shSeria == null) {
			if (other.shSeria != null)
				return false;
		} else if (!shSeria.equals(other.shSeria))
			return false;
		if (shcat == null) {
			if (other.shcat != null)
				return false;
		} else if (!shcat.equals(other.shcat))
			return false;
		if (shlang == null) {
			if (other.shlang != null)
				return false;
		} else if (!shlang.equals(other.shlang))
			return false;
		if (shprice == null) {
			if (other.shprice != null)
				return false;
		} else if (!shprice.equals(other.shprice))
			return false;
		if (shyear != other.shyear)
			return false;
		if (titleSh == null) {
			if (other.titleSh != null)
				return false;
		} else if (!titleSh.equals(other.titleSh))
			return false;
		return true;
	}

}
