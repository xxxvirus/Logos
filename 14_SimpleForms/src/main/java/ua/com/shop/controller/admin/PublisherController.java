package ua.com.shop.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ua.com.shop.entity.Publisher;
import ua.com.shop.service.PublisherService;

@Controller
@RequestMapping("/admin/publisher")
public class PublisherController {
	
	@Autowired
	private PublisherService publisherService;
	
	@GetMapping
	public String show(Model model) {
		model.addAttribute("publishers", publisherService.findAll());
		return "admin-publisher";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		publisherService.delete(id);
		return "redirect:/admin/publisher";
	}

	@PostMapping
	public String save(@RequestParam String name) {
		Publisher pub = new Publisher(name);
		publisherService.save(pub);
		return "redirect:/admin/publisher";
	}

}
