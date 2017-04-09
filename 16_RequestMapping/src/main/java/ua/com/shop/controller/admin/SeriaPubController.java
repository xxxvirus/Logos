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
import ua.com.shop.entity.SeriaPub;
import ua.com.shop.service.PublisherService;
import ua.com.shop.service.SeriaPubService;

@Controller
@RequestMapping("/admin/seriaPub")
public class SeriaPubController {
	
	@Autowired
	private SeriaPubService seriaPubService;
	@Autowired
	private PublisherService publisherService;
	
	@GetMapping
	public String show(Model model) {
		model.addAttribute("series", seriaPubService.findAll());
		model.addAttribute("publishers", publisherService.findAll());
		return "admin-seriaPub";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		seriaPubService.delete(id);
		return "redirect:/admin/seriaPub";
	}

	@PostMapping
	public String save(@RequestParam String nameOfS, @RequestParam int publisherId) {
		SeriaPub seriaPub = new SeriaPub();
		seriaPub.setNameOfS(nameOfS);
		Publisher publisher = publisherService.findOne(publisherId);
		seriaPub.setPublisher(publisher);
		seriaPubService.save(seriaPub);
		return "redirect:/admin/seriaPub";
	}

}
