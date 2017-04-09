package ua.com.shop.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@NamedQueries({
	
	@NamedQuery(name = "FindBySeria", query = "select s from SeriaPub s where s.nameOfS=:name"),
	
})

@Entity
public class SeriaPub {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nameOfS;
	@ManyToOne
	private Publisher publisher;
	
	@OneToMany(mappedBy="shSeria")
	private List<Shop> shop = new ArrayList<>();

	public SeriaPub() {
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((nameOfS == null) ? 0 : nameOfS.hashCode());
		result = prime * result
				+ ((publisher == null) ? 0 : publisher.hashCode());
		result = prime * result + ((shop == null) ? 0 : shop.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof SeriaPub))
			return false;
		SeriaPub other = (SeriaPub) obj;
		if (id != other.id)
			return false;
		if (nameOfS == null) {
			if (other.nameOfS != null)
				return false;
		} else if (!nameOfS.equals(other.nameOfS))
			return false;
		if (publisher == null) {
			if (other.publisher != null)
				return false;
		} else if (!publisher.equals(other.publisher))
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
//		return "SeriaPub [id=" + id + ", nameOfS=" + nameOfS + "]";
//	}
	
}
