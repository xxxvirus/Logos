package ua.com.shop.controller.admin;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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

import ua.com.shop.entity.Publisher;
import ua.com.shop.service.PublisherService;
import ua.com.shop.validator.PublisherValidator;

@Controller
@RequestMapping("/admin/publisher")
@SessionAttributes("publisher")
public class PublisherController {
	
	@Autowired
	private PublisherService publisherService;
	
	@ModelAttribute("publisher")
	public Publisher getForm(){
		return new Publisher();
	}
	
	@InitBinder("publisher")
	protected void bind(WebDataBinder binder){
		binder.setValidator(new PublisherValidator(publisherService));
	}
	
	@GetMapping
	public String show(Model model) {
		model.addAttribute("publishers", publisherService.findAll());
		return "admin-publisher";
	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable int id, Model model){
		model.addAttribute("publisher", publisherService.findOne(id));
		show(model);
		return "admin-publisher";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		publisherService.delete(id);
		return "redirect:/admin/publisher";
	}

	@PostMapping
	public String save(@ModelAttribute("publisher") @Valid Publisher publisher, BindingResult br, Model model, SessionStatus status) {
		if(br.hasErrors()){
			return show(model);
		}
		publisherService.save(publisher);
		status.setComplete();
		return "redirect:/admin/publisher";
	}

}
