package ua.com.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@RequestMapping("/")
	public String index(){
		
		return "index";
	}
	//� ��� ��� ���� ���������� 
	//������� �� ��������� /admin
	@RequestMapping("/addbook")
	public String addbook(){
		//��� admin.jsp
		return "addbook";
	}
	
	
}
