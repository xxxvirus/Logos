package ua.com.shop.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import ua.com.shop.entity.Author;
import ua.com.shop.entity.Book;
import ua.com.shop.entity.Genre;
import ua.com.shop.service.AuthorService;
import ua.com.shop.service.BookService;
import ua.com.shop.service.GenreService;

@Controller
@RequestMapping("/admin/book")
@SessionAttributes("book")
public class BookController {

	@Autowired
	private BookService bookService;
	@Autowired
	private AuthorService authorService;
	@Autowired
	private GenreService genreService;

	@GetMapping
	public String show(Model model) {
		model.addAttribute("books", bookService.findAll());
		model.addAttribute("authors", authorService.findAll());
		model.addAttribute("genre", genreService.findAll());
		return "admin-book";
	}

	@GetMapping("/update/{id}")
	public String update(@PathVariable int id, Model model) {
		model.addAttribute("book", bookService.findOne(id));
		show(model);
		return "admin-book";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		bookService.delete(id);
		return "redirect:/admin/book";
	}

	@PostMapping
	public String save(@RequestParam String title, @RequestParam Integer pages,
			@RequestParam int firstpub, @RequestParam int authorId,
			@RequestParam List<Genre> genre) {
		Book book = new Book();
		book.setTitle(title);
		book.setPages(pages);
		book.setFirstpub(firstpub);
		Author author = authorService.findOne(authorId);
		book.setAuthor(author);
		genre = genreService.findAll();
		book.setGenre(genre);
		bookService.save(book);
		return "redirect:/admin/book";
	}

}
