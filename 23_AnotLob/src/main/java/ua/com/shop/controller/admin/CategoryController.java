package ua.com.shop.controller.admin;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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

import ua.com.shop.dto.filter.SimpleFilter;
import ua.com.shop.entity.Category;
import ua.com.shop.service.CategoryService;
import ua.com.shop.validator.CategoryValidator;
import static ua.com.shop.util.ParamBuilder.*;

@Controller
@RequestMapping("/admin/category")
@SessionAttributes("category")
public class CategoryController {
	
	@Autowired
	private CategoryService catService;
	
	@ModelAttribute("filter")
	public SimpleFilter getFilter(){
		return new SimpleFilter();
	}
	
	@ModelAttribute("category")
	public Category getForm(){
		return new Category();
	}
	
	@InitBinder("category")
	protected void bind(WebDataBinder binder){
		binder.setValidator(new CategoryValidator(catService));
	}
	
	@GetMapping
	public String show(Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") SimpleFilter filter){
		model.addAttribute("page", catService.findAll(pageable, filter));
		return "admin-category";
	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable int id, Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") SimpleFilter filter){
		model.addAttribute("category",catService.findOne(id));
		show(model, pageable, filter);
		return "admin-category";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id, @PageableDefault Pageable pageable, @ModelAttribute("filter") SimpleFilter filter){
		catService.delete(id);
		return "redirect:/admin/category"+getParams(pageable, filter);
	}
	
	@PostMapping
	public String save(@ModelAttribute("category") @Valid Category category, BindingResult br, Model model, SessionStatus status, @PageableDefault Pageable pageable, @ModelAttribute("filter") SimpleFilter filter){
		if(br.hasErrors()){
			return show(model, pageable, filter);
		}
		catService.save(category);
		status.setComplete();
		return "redirect:/admin/category"+getParams(pageable, filter);
	}

}
