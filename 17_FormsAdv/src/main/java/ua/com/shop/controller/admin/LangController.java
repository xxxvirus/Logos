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

import ua.com.shop.entity.Languages;
import ua.com.shop.service.LanguagesService;

@Controller
@RequestMapping("/admin/lang")
@SessionAttributes("lang")
public class LangController {
	
	@Autowired
	private LanguagesService langService;
	
	@ModelAttribute("lang")
	public Languages getForm(){
		return new Languages();
	}
	
	@GetMapping
	public String show(Model model) {
		model.addAttribute("langM", langService.findAll());
		return "admin-lang";
	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable int id, Model model){
		model.addAttribute("lang", langService.findOne(id));
		show(model);
		return "admin-lang";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		langService.delete(id);
		return "redirect:/admin/lang";
	}

	@PostMapping
	public String save(@ModelAttribute("lang") Languages language, SessionStatus status) {
		langService.save(language);
		status.setComplete();
		return "redirect:/admin/lang";
	}

}
