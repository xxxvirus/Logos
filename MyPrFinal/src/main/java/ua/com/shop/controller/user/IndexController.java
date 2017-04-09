package ua.com.shop.controller.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.com.shop.service.AuthorService;
import ua.com.shop.service.BookService;
import ua.com.shop.service.CategoryService;
import ua.com.shop.service.PublisherService;
import ua.com.shop.service.SeriaPubService;
import ua.com.shop.service.ShopService;

@Controller
public class IndexController {
	
	@Autowired
	private BookService bookService;
	@Autowired
	private CategoryService catService;
	@Autowired
	private ShopService shopService;
	@Autowired
	private PublisherService publisherService;
	@Autowired
	private SeriaPubService seriaService;
	@Autowired
	private AuthorService authorService;
	
	@RequestMapping("/")
	public String index(Model model){
		model.addAttribute("categories", catService.findAll());
		return "user-index";
	}
	
	@RequestMapping("/category/{id}")
	public String category(@PathVariable int id, Model model){
		model.addAttribute("category", catService.findOne(id));
		model.addAttribute("shops", shopService.findByCategoryId(id));
		return "user-category";
	}
	
	@RequestMapping("/book/{id}")
	public String book(@PathVariable int id, Model model){
		model.addAttribute("book", bookService.findOne(id));
		model.addAttribute("shops", shopService.findByBookId(id));
		return "user-book";
	}
	
	@RequestMapping("/publisher/{id}")
	public String publisher(@PathVariable int id, Model model){
		model.addAttribute("publisher", publisherService.findOne(id));
		model.addAttribute("serias", seriaService.findByPublisherId(id));
		return "user-publisher";
	}
	
	@RequestMapping("/author/{id}")
	public String author(@PathVariable int id, Model model){
		model.addAttribute("author", authorService.findOne(id));
		model.addAttribute("books", bookService.findByAuthorId(id));
		return "user-author";
	}
	
	@RequestMapping("/contact")
	public String contact(){
		return "user-contact";
	}
	
	@RequestMapping("/delivery")
	public String delivery(){
		return "user-delivery";
	}
	
	@RequestMapping("/payment")
	public String payment(){
		return "user-payment";
	}
	
	@RequestMapping("/about")
	public String about(){
		return "user-about";
	}
	
	@RequestMapping("/admin")
	public String admin(){
		return "admin-admin";
	}
	
}
