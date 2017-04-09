package ua.com.shop.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ua.com.shop.entity.SeriaPub;
import ua.com.shop.service.SeriaPubService;

@Controller
@RequestMapping("/admin/seriaPub")
public class SeriaPubController {
	
	@Autowired
	private SeriaPubService seriaPubService;
	
	@GetMapping
	public String show(Model model) {
		model.addAttribute("series", seriaPubService.findAll());
		return "admin-seriaPub";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		seriaPubService.delete(id);
		return "redirect:/admin/seriaPub";
	}

	@PostMapping
	public String save(@RequestParam String nameOfS, @RequestParam String name) {
		SeriaPub seriaPub = new SeriaPub(nameOfS);
		seriaPubService.save(seriaPub);
		seriaPubService.createPublisherAndSeria(nameOfS, name);
		return "redirect:/admin/seriaPub";
	}

}
