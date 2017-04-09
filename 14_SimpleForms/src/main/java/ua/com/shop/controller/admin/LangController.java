package ua.com.shop.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ua.com.shop.entity.Languages;
import ua.com.shop.service.LanguagesService;

@Controller
@RequestMapping("/admin/lang")
public class LangController {
	
	@Autowired
	private LanguagesService langService;
	
	@GetMapping
	public String show(Model model) {
		model.addAttribute("langM", langService.findAll());
		return "admin-lang";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		langService.delete(id);
		return "redirect:/admin/lang";
	}

	@PostMapping
	public String save(@RequestParam String lang) {
		Languages langg = new Languages(lang);
		langService.save(langg);
		return "redirect:/admin/lang";
	}

}
