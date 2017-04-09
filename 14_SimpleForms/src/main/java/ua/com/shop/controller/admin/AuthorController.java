package ua.com.shop.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ua.com.shop.entity.Author;
import ua.com.shop.service.AuthorService;

@Controller
@RequestMapping("/admin/authors")
public class AuthorController {

	@Autowired
	private AuthorService authorService;

	@GetMapping
	public String show(Model model) {
		model.addAttribute("authorM", authorService.findAll());
		return "admin-authors";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		authorService.delete(id);
		return "redirect:/admin/authors";
	}

	@PostMapping
	public String save(@RequestParam String name, @RequestParam String surname,
			@RequestParam int born, @RequestParam int dead,
			@RequestParam String wiki) {
		Author author = new Author(name, surname, born, dead, wiki);
		authorService.save(author);
		return "redirect:/admin/authors";
	}
}
