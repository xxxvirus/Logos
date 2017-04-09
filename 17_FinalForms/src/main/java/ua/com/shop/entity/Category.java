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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((nameOfC == null) ? 0 : nameOfC.hashCode());
		result = prime * result + ((shop == null) ? 0 : shop.hashCode());
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
		Category other = (Category) obj;
		if (id != other.id)
			return false;
		if (nameOfC == null) {
			if (other.nameOfC != null)
				return false;
		} else if (!nameOfC.equals(other.nameOfC))
			return false;
		if (shop == null) {
			if (other.shop != null)
				return false;
		} else if (!shop.equals(other.shop))
			return false;
		return true;
	}
	
	
	
	

//	@Override
//	public String toString() {
//		return "Category [id=" + id + ", nameOfC=" + nameOfC + "]";
//	}
	
}
