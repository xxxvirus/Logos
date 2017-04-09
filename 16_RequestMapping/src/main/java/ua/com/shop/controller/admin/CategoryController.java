package ua.com.shop.controller.admin;

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

import ua.com.shop.entity.Category;
import ua.com.shop.service.CategoryService;

@Controller
@RequestMapping("/admin/category")
@SessionAttributes("category")
public class CategoryController {
	
	@Autowired
	private CategoryService catService;
	
	@ModelAttribute("category")
	public Category getForm(){
		return new Category();
	}
	
	@GetMapping
	public String show(Model model){
		model.addAttribute("categories", catService.findAll());
		return "admin-category";
	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable int id, Model model){
		model.addAttribute("category",catService.findOne(id));
		show(model);
		return "admin-category";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id){
		catService.delete(id);
		return "redirect:/admin/category";
	}
	
	@PostMapping
	public String save(@ModelAttribute("category") Category category, SessionStatus status){
		catService.save(category);
		status.setComplete();
		return "redirect:/admin/category";
	}

}
