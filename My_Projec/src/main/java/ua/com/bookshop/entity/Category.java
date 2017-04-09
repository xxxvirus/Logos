package ua.com.bookshop.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nameOfC;
	
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

	@Override
	public String toString() {
		return "Category [id=" + id + ", nameOfC=" + nameOfC + "]";
	}
	
}
