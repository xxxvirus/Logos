package ua.com.shop.controller.admin;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ua.com.shop.entity.Book;
import ua.com.shop.service.BookService;

@Controller
@RequestMapping("/admin/books")
public class BookController {

	@Autowired
	private BookService bookService;
	
	@RequestMapping
	public String show(Model model){
		model.addAttribute("booksM", bookService.findAll());
		return "admin-books";
	}
	
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable int id){
		bookService.delete(id);
		return "redirect:/admin/books";
	}
	
	@RequestMapping(method=POST)
	public String save(@RequestParam String title, @RequestParam Integer pages){
		bookService.save(new Book(title, pages));
		return "redirect:/admin/books";
	}
	
}
