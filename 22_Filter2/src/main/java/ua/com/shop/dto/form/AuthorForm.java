package ua.com.shop.dto.form;

public class AuthorForm {

	private int id;
	private String name;
	private String surname;
	private String yearOfBorn;
	private String yearOfDead;
	private String wiki;

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

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getYearOfBorn() {
		return yearOfBorn;
	}

	public void setYearOfBorn(String yearOfBorn) {
		this.yearOfBorn = yearOfBorn;
	}

	public String getYearOfDead() {
		return yearOfDead;
	}

	public void setYearOfDead(String yearOfDead) {
		this.yearOfDead = yearOfDead;
	}

	public String getWiki() {
		return wiki;
	}

	public void setWiki(String wiki) {
		this.wiki = wiki;
	}

}
