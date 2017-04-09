package ua.com.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@RequestMapping("/")
	public String index(){
		
		return "index";
	}
	//а цей тод≥ коли користувач 
	//натисне на писиланн€ /admin
	@RequestMapping("/addbook")
	public String addbook(){
		//тут admin.jsp
		return "addbook";
	}
	
	
}
