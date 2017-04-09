package ua.com.shop.dto.rest;

import java.math.BigDecimal;

public class ShopDto {

	private int id;
	private String titleShName;
	private String shSeriaName;
	private String shlangName;
	private String shcatName;
	private int shyear;
	private BigDecimal shprice;
	private String isbn;
	private int edition;
	private int shpage;
	private String anotation;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitleShName() {
		return titleShName;
	}

	public void setTitleShName(String titleShName) {
		this.titleShName = titleShName;
	}

	public String getShSeriaName() {
		return shSeriaName;
	}

	public void setShSeriaName(String shSeriaName) {
		this.shSeriaName = shSeriaName;
	}

	public String getShlangName() {
		return shlangName;
	}

	public void setShlangName(String shlangName) {
		this.shlangName = shlangName;
	}

	public String getShcatName() {
		return shcatName;
	}

	public void setShcatName(String shcatName) {
		this.shcatName = shcatName;
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

	public int getShpage() {
		return shpage;
	}

	public void setShpage(int shpage) {
		this.shpage = shpage;
	}

	public String getAnotation() {
		return anotation;
	}

	public void setAnotation(String anotation) {
		this.anotation = anotation;
	}

}
