package ua.com.shop.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ua.com.shop.entity.Category;
import ua.com.shop.service.CategoryService;

@Controller
@RequestMapping("/admin/category")
public class CategoryController {
	
	@Autowired
	private CategoryService catService;
	
	@GetMapping
	public String show(Model model){
		model.addAttribute("categories", catService.findAll());
		return "admin-category";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id){
		catService.delete(id);
		return "redirect:/admin/category";
	}
	
	@PostMapping
	public String save(@RequestParam String nameOfC){
		Category cat = new Category(nameOfC);
		catService.save(cat);
		return "redirect:/admin/category";
	}

}
