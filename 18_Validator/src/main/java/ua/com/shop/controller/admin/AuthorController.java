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

import ua.com.shop.entity.Author;
import ua.com.shop.service.AuthorService;

@Controller
@RequestMapping("/admin/author")
@SessionAttributes("author")
public class AuthorController {

	@Autowired
	private AuthorService authorService;
	
	@ModelAttribute("author")
	public Author getForm(){
		return new Author();
	}

	@GetMapping
	public String show(Model model) {
		model.addAttribute("authors", authorService.findAll());
		return "admin-author";
	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable int id, Model model){
		model.addAttribute("author", authorService.findOne(id));
		show(model);
		return "admin-author";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		authorService.delete(id);
		return "redirect:/admin/author";
	}

	@PostMapping
	public String save(@ModelAttribute("author") Author author, SessionStatus status) {
		authorService.save(author);
		status.setComplete();
		return "redirect:/admin/author";
	}
}
