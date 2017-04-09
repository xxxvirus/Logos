package ua.com.shop.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.com.shop.service.OrdersService;

@Controller
@RequestMapping("/admin/order")
public class OrdersController {

	@Autowired
	private OrdersService ordersService;

	@RequestMapping
	public String show(Model model) {
		model.addAttribute("orders", ordersService.findAll());
		return "admin-order";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		ordersService.delete(id);
		return "redirect:/admin/order";
	}

}
