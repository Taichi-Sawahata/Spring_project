package com.example.demo.calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {

	@GetMapping("/calculator")
	public String showCalculator() {
		return "calculator";
	}

	private final CalculatorService calculatorService;

	@Autowired
	public CalculatorController(CalculatorService calculatorService) {
		this.calculatorService = calculatorService;
	}

	@GetMapping("/calculate")
	public String calculate(@RequestParam("operand1") int operand1, @RequestParam("operand2") int operand2,
			@RequestParam("select") String option, Model model) {

		int result = calculatorService.calculate(operand1, operand2, option);

		model.addAttribute("calculate", result);

		return "calculator";
	}
}