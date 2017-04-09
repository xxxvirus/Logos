package ua.com.shop.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Publisher {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	@OneToMany(mappedBy="publisher")
	private List<SeriaPub> listOfS;
	
	public Publisher() {
	}

	public Publisher(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<SeriaPub> getListOfS() {
		return listOfS;
	}

	public void setListOfS(List<SeriaPub> listOfS) {
		this.listOfS = listOfS;
	}

//	@Override
//	public String toString() {
//		return "Publisher [id=" + id + ", name=" + name + "]";
//	}
	
}
