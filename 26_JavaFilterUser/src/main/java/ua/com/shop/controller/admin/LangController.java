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
import ua.com.shop.entity.Languages;
import ua.com.shop.service.LanguagesService;
import ua.com.shop.validator.LanguagesValidator;
import static ua.com.shop.util.ParamBuilder.*;

@Controller
@RequestMapping("/admin/lang")
@SessionAttributes("lang")
public class LangController {
	
	@Autowired
	private LanguagesService langService;
	
	@ModelAttribute("filter")
	public SimpleFilter getFilter(){
		return new SimpleFilter();
	}
	
	@ModelAttribute("lang")
	public Languages getForm(){
		return new Languages();
	}
	
	@InitBinder("lang")
	protected void bind(WebDataBinder binder){
		binder.setValidator(new LanguagesValidator(langService));
	}
	
	@GetMapping
	public String show(Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") SimpleFilter filter) {
		model.addAttribute("page", langService.findAll(pageable, filter));
		return "admin-lang";
	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable int id, Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") SimpleFilter filter){
		model.addAttribute("lang", langService.findOne(id));
		show(model, pageable, filter);
		return "admin-lang";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id, @PageableDefault Pageable pageable, @ModelAttribute("filter") SimpleFilter filter) {
		langService.delete(id);
		return "redirect:/admin/lang"+getParams(pageable, filter);
	}

	@PostMapping
	public String save(@ModelAttribute("lang") @Valid Languages language, BindingResult br, Model model, SessionStatus status, @PageableDefault Pageable pageable, @ModelAttribute("filter") SimpleFilter filter) {
		if(br.hasErrors()){
			return show(model, pageable, filter);
		}
		langService.save(language);
		status.setComplete();
		return "redirect:/admin/lang"+getParams(pageable, filter);
	}

}
