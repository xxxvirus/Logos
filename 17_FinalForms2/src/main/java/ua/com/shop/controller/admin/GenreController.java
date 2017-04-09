package ua.com.shop.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import ua.com.shop.entity.Book;
import ua.com.shop.entity.Genre;
import ua.com.shop.service.BookService;
import ua.com.shop.service.GenreService;

@Controller
@RequestMapping("/admin/genre")
@SessionAttributes("genre")
public class GenreController {

	@Autowired
	private GenreService genreService;
	@Autowired
	private BookService bookService;
	
	@ModelAttribute("genre")
	public Genre getForm(){
		return new Genre();
	}
	
	@GetMapping
	public String show(Model model){
		model.addAttribute("genres", genreService.findAll());
		return "admin-genre";
	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable int id, Model model){
		model.addAttribute("genre", genreService.findOne(id));
		show(model);
		return "admin-genre";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id){
		genreService.delete(id);
		return "redirect:/admin/genre";
	}
	
	@PostMapping
	public String save(@ModelAttribute("genre") Genre genre, SessionStatus status){
		genreService.save(genre);
		status.setComplete();
		return "redirect:/admin/genre";
	}
	
	@GetMapping("/add/book/{id}")
	public String showBook(@PathVariable int id, Model model){
		Genre genre = genreService.loadBooks(id);
		model.addAttribute("genre", genre);
		List<Book> books = bookService.findAll();
		books.removeAll(genre.getBook());
		model.addAttribute("book", books);
		return "admin-book";
	}
	
	@GetMapping("/add/book/{id}/{bookId}")
	public String saveBook(@PathVariable int id, @PathVariable int bookId){
		genreService.addBook(id, bookId);
		return "redirect:/admin/genre/book/"+id;
	}
	
	@PostMapping("/delete/book/{id}/{bookId}")
	public String deleteBook(@PathVariable int id, @PathVariable int bookId){
		genreService.deleteBook(id, bookId);
		return "redirect:/admin/genre/book/"+id;
	}
}
