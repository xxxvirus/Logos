package ua.com.shop.dto.form;

import java.util.List;

import ua.com.shop.entity.Author;
import ua.com.shop.entity.Genre;

public class BookForm {

	private int id;
	private String title;
	private String pages;
	private String firstpub;
	private Author author;
	private List<Genre> genres;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPages() {
		return pages;
	}

	public void setPages(String pages) {
		this.pages = pages;
	}

	public String getFirstpub() {
		return firstpub;
	}

	public void setFirstpub(String firstpub) {
		this.firstpub = firstpub;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public List<Genre> getGenres() {
		return genres;
	}

	public void setGenres(List<Genre> genres) {
		this.genres = genres;
	}

}
