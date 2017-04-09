package ua.com.shop.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import ua.com.shop.editor.AuthorEditor;
import ua.com.shop.editor.GenreEditor;
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
	
	@InitBinder("book")
	protected void bind(WebDataBinder binder){
		binder.registerCustomEditor(Author.class, new AuthorEditor(authorService));
		binder.registerCustomEditor(Genre.class, new GenreEditor(genreService));
	}
	
	@ModelAttribute("book")
	public Book getForm(){
		return new Book();
	}
	
	@GetMapping
	public String show(Model model){
		model.addAttribute("books", bookService.findAll());
		model.addAttribute("authors", authorService.findAll());
		model.addAttribute("genres", genreService.findAll());
		return "admin-book";
	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable int id, Model model){
		model.addAttribute("book", bookService.findOne(id));
//		model.addAttribute("books", bookService.findAll());
//		Book book = bookService.loadgenre(id);
//		model.addAttribute("book", book);
//		List<Genre> genre = genreService.findAll();
//		model.addAttribute("genre", genre);
		return show(model);
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id){
		bookService.delete(id);
		return "redirect:/admin/book";
	}
	
	@PostMapping
	public String save(@ModelAttribute("book") Book book, SessionStatus status){
		bookService.save(book);
		status.setComplete();
		return "redirect:/admin/book";
	}
	
}
