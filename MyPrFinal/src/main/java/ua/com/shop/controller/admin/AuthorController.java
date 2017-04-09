package ua.com.shop.controller.admin;

import static org.springframework.web.bind.annotation.RequestMethod.POST;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ua.com.shop.entity.Author;
import ua.com.shop.service.AuthorService;

@Controller
@RequestMapping("/admin/authors")
public class AuthorController {

	@Autowired
	private AuthorService authorService;
	
	@RequestMapping
	public String show(Model model){
		model.addAttribute("authorM", authorService.findAll());
		return "admin-authors";
	}
	
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable int id){
		authorService.delete(id);
		return "redirect:/admin/authors";
	}
	
	@RequestMapping(method=POST)
	public String save(@RequestParam String name, @RequestParam String surname){
		authorService.save(new Author(name, surname));
		return "redirect:/admin/authors";
	}
}
