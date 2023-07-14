package com.example.demo.calculator;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

	public int calculate(int num1, int num2, String option) {

		switch (option) {

		case "+":
			return num1 + num2;

		case "-":
			return num1 - num2;

		case "*":
			return num1 * num2;

		default:
			return num1 / num2;
		}
	}
}
