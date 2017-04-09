package ua.com.bookshop.dao;

public class ADaoGen<A> {

	private A authors;

	public ADaoGen(A authors) {
		this.authors = authors;
	}

	public A getAuthors() {
		return authors;
	}

	public void setAuthors(A authors) {
		this.authors = authors;
	}
	
}
