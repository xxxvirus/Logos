package ua.com.shop.controller.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ua.com.shop.dto.rest.ShopDto;
import ua.com.shop.entity.Author;
import ua.com.shop.service.AuthorService;
import ua.com.shop.service.ShopService;

@RestController
@RequestMapping("/author/{id}")
public class AuthorControllerUser {

	@Autowired
	private ShopService shopService;
	@Autowired
	private AuthorService authorService;
	
	@GetMapping(headers={"Accept=application/json"})
	public List<ShopDto> findByAuthorId(@PathVariable int id) {
		return shopService.findByAuthorId(id);
	}
	
//	@GetMapping(headers={"Accept=application/json"})
//	public List<ShopDto> findAllDto() {
//		return shopService.findAllDto();
//	}
	
	@RequestMapping("/{id}")
	public Author findOne(@PathVariable int id) {
		return authorService.findOne(id);
	}
}
