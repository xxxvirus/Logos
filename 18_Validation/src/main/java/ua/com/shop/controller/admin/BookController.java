package ua.com.shop.controller.admin;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import ua.com.shop.dto.form.BookForm;
import ua.com.shop.editor.AuthorEditor;
import ua.com.shop.entity.Author;
import ua.com.shop.service.AuthorService;
import ua.com.shop.service.BookService;
import ua.com.shop.validator.BookValidator;

@Controller
@RequestMapping("/admin/book")
@SessionAttributes("book")
public class BookController {

	@Autowired
	private BookService bookService;
	@Autowired
	private AuthorService authorService;
	
	@InitBinder("book")
	protected void bind(WebDataBinder binder){
		binder.registerCustomEditor(Author.class, new AuthorEditor(authorService));
		binder.setValidator(new BookValidator(bookService));
	}
	
	@ModelAttribute("book")
	public BookForm getForm(){
		return new BookForm();
	}
	
	@GetMapping
	public String show(Model model){
		model.addAttribute("books", bookService.findAll());
		model.addAttribute("authors", authorService.findAll());
		return "admin-book";
	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable int id, Model model){
		model.addAttribute("book", bookService.findForm(id));
		return show(model);
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id){
		bookService.delete(id);
		return "redirect:/admin/book";
	}
	
	@PostMapping
	public String save(@ModelAttribute("book") @Valid BookForm book, BindingResult br, Model model, SessionStatus status){
		if(br.hasErrors()) return show(model);
		bookService.save(book);
		status.setComplete();
		return "redirect:/admin/book";
	}
	
}
