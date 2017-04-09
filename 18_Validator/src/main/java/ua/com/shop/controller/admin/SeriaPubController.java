package ua.com.shop.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import ua.com.shop.editor.PublisherEditor;
import ua.com.shop.entity.Publisher;
import ua.com.shop.entity.SeriaPub;
import ua.com.shop.service.PublisherService;
import ua.com.shop.service.SeriaPubService;

@Controller
@RequestMapping("/admin/seriaPub")
@SessionAttributes("seriaPub")
public class SeriaPubController {
	
	@Autowired
	private SeriaPubService seriaPubService;
	@Autowired
	private PublisherService publisherService;
	
	@InitBinder("seriaPub")
	protected void bind(WebDataBinder binder){
		binder.registerCustomEditor(Publisher.class, new PublisherEditor(publisherService));
	}
	
	@ModelAttribute("seriaPub")
	public SeriaPub getForm(){
		return new SeriaPub();
	}
	
	@GetMapping
	public String show(Model model) {
		model.addAttribute("series", seriaPubService.findAll());
		model.addAttribute("publishers", publisherService.findAll());
		return "admin-seriaPub";
	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable int id, Model model){
		model.addAttribute("seriaPub", seriaPubService.findOne(id));
		return show(model);
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		seriaPubService.delete(id);
		return "redirect:/admin/seriaPub";
	}

	@PostMapping
	public String save(@ModelAttribute("seriaPub") SeriaPub seriaPub, SessionStatus status) {
		seriaPubService.save(seriaPub);
		status.setComplete();
		return "redirect:/admin/seriaPub";
	}

}
