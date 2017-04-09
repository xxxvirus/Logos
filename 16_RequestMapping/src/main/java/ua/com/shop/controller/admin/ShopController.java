package ua.com.shop.controller.admin;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ua.com.shop.entity.Book;
import ua.com.shop.entity.Category;
import ua.com.shop.entity.Languages;
import ua.com.shop.entity.SeriaPub;
import ua.com.shop.entity.Shop;
import ua.com.shop.service.BookService;
import ua.com.shop.service.CategoryService;
import ua.com.shop.service.LanguagesService;
import ua.com.shop.service.SeriaPubService;
import ua.com.shop.service.ShopService;

@Controller
@RequestMapping("/admin/shop")
public class ShopController {

	@Autowired
	private ShopService shopService;
	@Autowired
	private BookService bookService;
	@Autowired
	private CategoryService catService;
	@Autowired
	private LanguagesService langService;
	@Autowired
	private SeriaPubService seriaPubService;

	@GetMapping
	public String show(Model model) {
		model.addAttribute("shops", shopService.findAll());
		model.addAttribute("books", bookService.findAll());
		model.addAttribute("categories", catService.findAll());
		model.addAttribute("langM", langService.findAll());
		model.addAttribute("series", seriaPubService.findAll());
		return "admin-shop";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		shopService.delete(id);
		return "redirect:/admin/shop";
	}

	@PostMapping
	public String save(@RequestParam int edition, String isbn,
			BigDecimal price, int yearOfPub, int bookId, int catId, int langId,
			int seriaPubId) {
		Shop shop = new Shop();
		shop.setEdition(edition);
		shop.setIsbn(isbn);
		shop.setShprice(price);
		shop.setShyear(yearOfPub);
		Book book = bookService.findOne(bookId);
		shop.setShbook(book);
		Category cat = catService.findOne(catId);
		shop.setShcat(cat);
		Languages lang = langService.findOne(langId);
		shop.setShlang(lang);
		SeriaPub spub = seriaPubService.findOne(seriaPubId);
		shop.setShSeria(spub);
		shopService.save(shop);
		return "redirect:/admin/shop";
	}
}
