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
import ua.com.shop.entity.Publisher;
import ua.com.shop.service.PublisherService;
import ua.com.shop.validator.PublisherValidator;
import static ua.com.shop.util.ParamBuilder.*;

@Controller
@RequestMapping("/admin/publisher")
@SessionAttributes("publisher")
public class PublisherController {
	
	@Autowired
	private PublisherService publisherService;
	
	@ModelAttribute("filter")
	public SimpleFilter getFilter(){
		return new SimpleFilter();
	}
	
	@ModelAttribute("publisher")
	public Publisher getForm(){
		return new Publisher();
	}
	
	@InitBinder("publisher")
	protected void bind(WebDataBinder binder){
		binder.setValidator(new PublisherValidator(publisherService));
	}
	
	@GetMapping
	public String show(Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") SimpleFilter filter) {
		model.addAttribute("page", publisherService.findAll(pageable, filter));
		return "admin-publisher";
	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable int id, Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") SimpleFilter filter){
		model.addAttribute("publisher", publisherService.findOne(id));
		show(model, pageable, filter);
		return "admin-publisher";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id, @PageableDefault Pageable pageable, @ModelAttribute("filter") SimpleFilter filter) {
		publisherService.delete(id);
		return "redirect:/admin/publisher"+getParams(pageable, filter);
	}

	@PostMapping
	public String save(@ModelAttribute("publisher") @Valid Publisher publisher, BindingResult br, Model model, SessionStatus status, @PageableDefault Pageable pageable, @ModelAttribute("filter") SimpleFilter filter) {
		if(br.hasErrors()){
			return show(model, pageable, filter);
		}
		publisherService.save(publisher);
		status.setComplete();
		return "redirect:/admin/publisher"+getParams(pageable, filter);
	}

}
