package ua.com.shop.controller.user;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import ua.com.shop.dto.filter.ShopFilter;
import ua.com.shop.dto.filter.ShopFilterByAuthorId;
import ua.com.shop.entity.Orders;
import ua.com.shop.entity.Shop;
import ua.com.shop.entity.User;
import ua.com.shop.service.AuthorService;
import ua.com.shop.service.BookService;
import ua.com.shop.service.CategoryService;
import ua.com.shop.service.GenreService;
import ua.com.shop.service.LanguagesService;
import ua.com.shop.service.OrdersService;
import ua.com.shop.service.PublisherService;
import ua.com.shop.service.SeriaPubService;
import ua.com.shop.service.ShopService;
import ua.com.shop.service.TitleShopService;
import ua.com.shop.service.UserService;

@Controller
@SessionAttributes({ "shop", "order" })
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
	@Autowired
	private GenreService genreService;
	@Autowired
	private UserService userService;
	@Autowired
	private OrdersService ordersService;
	
	@ModelAttribute("order")
	public Orders getOrders() {
		return new Orders();
	}
	
//	@ModelAttribute("filter")
//	public ShopFilter getFilter(){
//		return new ShopFilter();
//	}
	
	@ModelAttribute("filter")
	public ShopFilterByAuthorId getFilter(){
		return new ShopFilterByAuthorId();
	}
	
	@RequestMapping("/author/{id}")
	public String author(@PathVariable int id, Model model, @ModelAttribute("order") Orders order, @PageableDefault Pageable pageable,
			@ModelAttribute("filter") ShopFilterByAuthorId filter){
		model.addAttribute("author", authorService.findOne(id));
		model.addAttribute("ord", order);
//		model.addAttribute("page", shopService.findAll(pageable, filter));
		model.addAttribute("page", shopService.findByAuthor(pageable, filter, id));
		//Filter
		model.addAttribute("langM", langService.findAll());
		model.addAttribute("series", seriaPubService.findAll());
		model.addAttribute("publishers", publisherService.findAll());
		return "user-author";
	}
	
	@PostMapping("/author/{idd}/addtocart/{id}")
	public String addToCartC(@PathVariable int idd, Model model, @PageableDefault Pageable pageable, @PathVariable int id, @ModelAttribute("order") Orders order,
			@ModelAttribute("filter") ShopFilterByAuthorId filter) {
		model.addAttribute("author", authorService.findOne(idd));
		User user = (User) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		order.setUser(user);
		Shop shop = shopService.findOne(id);
		if (order.getShops() == null)
			order.setShops(new ArrayList<Shop>());
		if (!order.getShops().contains(shop))
			order.getShops().add(shop);
		return author(idd, model, order, pageable, filter);
	}
}
