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

import ua.com.shop.dto.form.AuthorForm;
import ua.com.shop.service.AuthorService;
import ua.com.shop.validator.AuthorValidator;

@Controller
@RequestMapping("/admin/author")
@SessionAttributes("author")
public class AuthorController {

	@Autowired
	private AuthorService authorService;
	
	@InitBinder("author")
	protected void bind(WebDataBinder binder){
		binder.setValidator(new AuthorValidator(authorService));
	}
	
	@ModelAttribute("author")
	public AuthorForm getForm(){
		return new AuthorForm();
	}

	@GetMapping
	public String show(Model model) {
		model.addAttribute("authors", authorService.findAll());
		return "admin-author";
	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable int id, Model model){
		model.addAttribute("author", authorService.findForm(id));
		show(model);
		return "admin-author";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		authorService.delete(id);
		return "redirect:/admin/author";
	}

	@PostMapping
	public String save(@ModelAttribute("author") @Valid AuthorForm author, BindingResult br, Model model, SessionStatus status) {
		if(br.hasErrors()) return show(model);
		authorService.save(author);
		status.setComplete();
		return "redirect:/admin/author";
	}
}
