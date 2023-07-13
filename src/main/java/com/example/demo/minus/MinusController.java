package com.example.demo.minus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MinusController {

	@GetMapping("minus")
	public String doGet() {
		return "minus.html";
	}

	private final MinusService minusService;

	@Autowired
	public MinusController(MinusService minusService) {
		this.minusService = minusService;
	}

	@GetMapping("cal")
	public String doGet(@RequestParam("plus") int plus, @RequestParam("minus") int minus, Model model) {

		int result = 0;

		result = minusService.minus(plus, minus);

		model.addAttribute("minus", result);

		return "minus.html";
	}
}
