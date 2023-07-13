package com.example.demo.multi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MultiController {

	private final MultiService multiService;

	@Autowired
	public MultiController(MultiService multiService) {
		this.multiService = multiService;
	}

	@GetMapping("multi")
	public String multi(Model model) {

		String result = "";

		result = String.valueOf(multiService.multi(5, 6));

		model.addAttribute("result", result);

		return "multi.html";
	}
}
