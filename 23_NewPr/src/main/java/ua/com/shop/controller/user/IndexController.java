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

import ua.com.shop.dto.filter.ShopFilter;
import ua.com.shop.dto.filter.SimpleFilter;
import ua.com.shop.service.AuthorService;
import ua.com.shop.service.BookService;
import ua.com.shop.service.CategoryService;
import ua.com.shop.service.LanguagesService;
import ua.com.shop.service.PublisherService;
import ua.com.shop.service.SeriaPubService;
import ua.com.shop.service.ShopService;
import ua.com.shop.service.TitleShopService;
import ua.com.shop.util.ParamBuilder;

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
	@Autowired
	private TitleShopService titleShopService;
	@Autowired
	private LanguagesService langService;
	@Autowired
	private SeriaPubService seriaPubService;
	
	@RequestMapping("/")
	public String index(Model model){
		model.addAttribute("categories", catService.findAll());
		model.addAttribute("authors", authorService.findAll());
		return "user-index";
	}
	
	@ModelAttribute("filter")
	public ShopFilter getFilter(){
		return new ShopFilter();
	}
	
	@ModelAttribute("filterS")
	public SimpleFilter getFilteSr(){
		return new SimpleFilter();
	}
	
	@RequestMapping("/category/{id}")
	public String category(@PathVariable int id, Model model){
		model.addAttribute("category", catService.findOne(id));
		model.addAttribute("shops", shopService.findByCategoryId(id));
		return "user-category";
	}
	
	@RequestMapping("/shop/{id}")
	public String book(@PathVariable int id, Model model){
		model.addAttribute("shop", shopService.findOne(id));
		return "user-shop";
	}
	
	@RequestMapping("/publisher/{id}")
	public String publisher(@PathVariable int id, Model model){
		model.addAttribute("publisher", publisherService.findOne(id));
		model.addAttribute("serias", seriaService.findByPublisherId(id));
		model.addAttribute("shops", shopService.findByPublisherId(id));
		return "user-publisher";
	}
	
	@RequestMapping("/author/{id}")
	public String author(@PathVariable int id, Model model, @PageableDefault Pageable pageable,
			@ModelAttribute("filter") ShopFilter filter){
//		model.addAttribute("page", shopService.findAll(pageable, filter));
		model.addAttribute("author", authorService.findOne(id));
//		model.addAttribute("books", bookService.findByAuthorId(id));
//		model.addAttribute("titleShops", titleShopService.findByAuthorId(id));
//		model.addAttribute("shops", shopService.findByAuthor(id));
		model.addAttribute("page", shopService.findAll(id, pageable, filter));
		model.addAttribute("categories", catService.findAll());
//		model.addAttribute("publisherA", publisherService.findAuthorPub(id));
		model.addAttribute("langA", langService.findAuthorLang(id));
		model.addAttribute("langM", langService.findAll());
//		model.addAttribute("series", seriaPubService.findAll());
		model.addAttribute("publishers", publisherService.findAll());
//		getParams(pageable, filter);
		return "user-author";
	}
	
//	@GetMapping("/author/{id}")
//	public String show(@PathVariable int id, Model model, @PageableDefault Pageable pageable,
//			@ModelAttribute("filter") ShopFilter filter) {
//		model.addAttribute("page", shopService.findAll(id, pageable, filter));
//		model.addAttribute("titleShops", titleShopService.findAll());
//		model.addAttribute("categories", catService.findAll());
//		model.addAttribute("langM", langService.findAll());
//		model.addAttribute("series", seriaPubService.findAll());
//		model.addAttribute("publishers", publisherService.findAll());
//		return "user-author";
//	}
	
	
	@RequestMapping("/search")
	public String search(Model model, @PageableDefault Pageable pageable, @ModelAttribute("filterS") SimpleFilter filter){
		model.addAttribute("page", catService.findAll(pageable, filter));
		return "user-search";
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
	
	private String getParams(Pageable pageable, ShopFilter filter){
		String page = ParamBuilder.getParams(pageable);
		StringBuilder buffer = new StringBuilder(page);
		if(!filter.getMax().isEmpty()){
			buffer.append("&max=");
			buffer.append(filter.getMax());
		}
		if(!filter.getMin().isEmpty()){
			buffer.append("&min=");
			buffer.append(filter.getMin());
		}
		if(!filter.getLanguageIds().isEmpty()){
			for (Integer id : filter.getLanguageIds()) {
				buffer.append("&languageIds=");
				buffer.append(id);
			}
		}
		if(!filter.getCategoryIds().isEmpty()){
			for (Integer id : filter.getCategoryIds()) {
				buffer.append("&categoryIds=");
				buffer.append(id);
			}
		}
		if(!filter.getPublisherIds().isEmpty()){
			for (Integer id : filter.getPublisherIds()) {
				buffer.append("&publisherIds=");
				buffer.append(id);
			}
		}
		return buffer.toString();
	}
	
}
