package ua.com.shop.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import ua.com.shop.dto.filter.ShopFilter;
import ua.com.shop.service.AuthorService;
import ua.com.shop.service.BookService;
import ua.com.shop.service.CategoryService;
import ua.com.shop.service.LanguagesService;
import ua.com.shop.service.PublisherService;
import ua.com.shop.service.SeriaPubService;
import ua.com.shop.service.ShopService;
import ua.com.shop.service.TitleShopService;

@Controller
@RequestMapping("/user/author/{id}")
@SessionAttributes("author")
public class AuthorControllerUser {

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
	@Autowired
	private TitleShopService titleShopService;
	@Autowired
	private LanguagesService langService;
	@Autowired
	private SeriaPubService seriaPubService;
	
	@ModelAttribute("filter")
	public ShopFilter getFilter() {
		return new ShopFilter();
	}
	
	@RequestMapping("/author/{id}")
	public String author(@PathVariable int id, Model model, @PageableDefault Pageable pageable,
			@ModelAttribute("filter") ShopFilter filter){
//		model.addAttribute("page", shopService.findAll(pageable, filter));
		model.addAttribute("author", authorService.findOne(id));
//		model.addAttribute("books", bookService.findByAuthorId(id));
//		model.addAttribute("titleShops", titleShopService.findByAuthorId(id));
//		model.addAttribute("shops", shopService.findByAuthor(id));
//		model.addAttribute("page", shopService.findAll(id, pageable, filter));
//		model.addAttribute("categories", catService.findAll());
//		model.addAttribute("publisherA", publisherService.findAuthorPub(id));
//		model.addAttribute("langA", langService.findAuthorLang(id));
//		model.addAttribute("langM", langService.findAll());
//		model.addAttribute("series", seriaPubService.findAll());
//		model.addAttribute("publishers", publisherService.findAll());
//		getParams(pageable, filter);
		return "user-author";
	}

	
	@GetMapping
	public String show(@PathVariable int id, Model model, @PageableDefault Pageable pageable,
			@ModelAttribute("filter") ShopFilter filter) {
		model.addAttribute("page", shopService.findAll(id, pageable, filter));
		
		return "user-author";
	}
}
