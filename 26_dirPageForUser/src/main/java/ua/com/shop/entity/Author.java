package ua.com.shop.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(indexes={@Index(columnList = "name"), @Index(columnList = "surname"), @Index(columnList = "yearOfBorn"), @Index(columnList = "yearOfDead"), @Index(columnList = "wiki")})
public class Author{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String surname;
	private int yearOfBorn;
	private int yearOfDead;
	private String wiki;
	@Lob
	private String biography;
	@OneToMany(mappedBy="author")
	private List<Book> books = new ArrayList<>();
	
	private int version;
	@Transient
	private MultipartFile file;
	
	public Author() {
	}

	public Author(String name, String surname) {
		this.name = name;
		this.surname = surname;
	}
	
	public Author(String name, String surname, int yearOfBorn, int yearOfDead, String wiki) {
		this.name = name;
		this.surname = surname;
		this.yearOfBorn = yearOfBorn;
		this.yearOfDead = yearOfDead;
		this.wiki = wiki;
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

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public int getYearOfBorn() {
		return yearOfBorn;
	}

	public void setYearOfBorn(int yearOfBorn) {
		this.yearOfBorn = yearOfBorn;
	}

	public String getWiki() {
		return wiki;
	}

	public void setWiki(String wiki) {
		this.wiki = wiki;
	}

	public int getYearOfDead() {
		return yearOfDead;
	}

	public void setYearOfDead(int yearOfDead) {
		this.yearOfDead = yearOfDead;
	}

	public String getBiography() {
		return biography;
	}

	public void setBiography(String biography) {
		this.biography = biography;
	}
	
	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((biography == null) ? 0 : biography.hashCode());
		result = prime * result + ((books == null) ? 0 : books.hashCode());
		result = prime * result + ((file == null) ? 0 : file.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
		result = prime * result + version;
		result = prime * result + ((wiki == null) ? 0 : wiki.hashCode());
		result = prime * result + yearOfBorn;
		result = prime * result + yearOfDead;
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
		Author other = (Author) obj;
		if (biography == null) {
			if (other.biography != null)
				return false;
		} else if (!biography.equals(other.biography))
			return false;
		if (books == null) {
			if (other.books != null)
				return false;
		} else if (!books.equals(other.books))
			return false;
		if (file == null) {
			if (other.file != null)
				return false;
		} else if (!file.equals(other.file))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		if (version != other.version)
			return false;
		if (wiki == null) {
			if (other.wiki != null)
				return false;
		} else if (!wiki.equals(other.wiki))
			return false;
		if (yearOfBorn != other.yearOfBorn)
			return false;
		if (yearOfDead != other.yearOfDead)
			return false;
		return true;
	}

	

//	@Override
//	public String toString() {
//		return "Author [id=" + id + ", name=" + name + ", surname=" + surname
//				+ "]";
//	}
	
}
