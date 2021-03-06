package ua.com.shop.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import ua.com.shop.entity.Author;
import ua.com.shop.entity.Book;
import ua.com.shop.service.AuthorService;
import ua.com.shop.service.BookService;

@Controller
@RequestMapping("/admin/book")
@SessionAttributes("book")
public class BookController {

	@Autowired
	private BookService bookService;
	@Autowired
	private AuthorService authorService;
	
	@ModelAttribute("book")
	public Book getForm(){
		return new Book();
	}
	
	@GetMapping
	public String show(Model model){
		model.addAttribute("books", bookService.findAll());
		model.addAttribute("authors", authorService.findAll());
		return "admin-book";
	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable int id, Model model){
		model.addAttribute("book", bookService.findOne(id));
		show(model);
		return "admin-book";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id){
		bookService.delete(id);
		return "redirect:/admin/books";
	}
	
	@PostMapping
	public String save(@RequestParam String title, @RequestParam Integer pages, @RequestParam int frirstpub, @RequestParam int authorId){
		Book book = new Book();
		book.setTitle(title);
		book.setPages(pages);
		book.setFrirstpub(frirstpub);
		Author author = authorService.findOne(authorId);
		book.setAuthor(author);
		bookService.save(book);
		return "redirect:/admin/books";
	}
	
}
