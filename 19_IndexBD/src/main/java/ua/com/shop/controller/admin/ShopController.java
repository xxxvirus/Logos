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

import ua.com.shop.dto.form.ShopForm;
import ua.com.shop.editor.CategoryEditor;
import ua.com.shop.editor.LangEditor;
import ua.com.shop.editor.SeriaPubEditor;
import ua.com.shop.editor.TitleShopEditor;
import ua.com.shop.entity.Category;
import ua.com.shop.entity.Languages;
import ua.com.shop.entity.SeriaPub;
import ua.com.shop.entity.TitleShop;
import ua.com.shop.service.CategoryService;
import ua.com.shop.service.LanguagesService;
import ua.com.shop.service.SeriaPubService;
import ua.com.shop.service.ShopService;
import ua.com.shop.service.TitleShopService;
import ua.com.shop.validator.ShopValidator;

@Controller
@RequestMapping("/admin/shop")
@SessionAttributes("shop")
public class ShopController {

	@Autowired
	private ShopService shopService;
	@Autowired
	private TitleShopService titleShopService;
	@Autowired
	private CategoryService catService;
	@Autowired
	private LanguagesService langService;
	@Autowired
	private SeriaPubService seriaPubService;

	@InitBinder("shop")
	protected void bind(WebDataBinder binder){
		binder.registerCustomEditor(TitleShop.class, new TitleShopEditor(titleShopService));
		binder.registerCustomEditor(Category.class, new CategoryEditor(catService));
		binder.registerCustomEditor(Languages.class, new LangEditor(langService));
		binder.registerCustomEditor(SeriaPub.class, new SeriaPubEditor(seriaPubService));
		binder.setValidator(new ShopValidator(shopService));
	}	
	
	@ModelAttribute("shop")
	public ShopForm getForm(){
		return new ShopForm();
	}
	
	@GetMapping
	public String show(Model model) {
		model.addAttribute("shops", shopService.findAll());
		model.addAttribute("titleShops", titleShopService.findAll());
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
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable int id, Model model){
		model.addAttribute("shop", shopService.findForm(id));
		return show(model);
	}

	@PostMapping
	public String save(@ModelAttribute("shop") @Valid ShopForm shop, BindingResult br, Model model, SessionStatus status) {
		if(br.hasErrors()) return show(model);
		shopService.save(shop);
		status.setComplete();
		return "redirect:/admin/shop";
	}
}
