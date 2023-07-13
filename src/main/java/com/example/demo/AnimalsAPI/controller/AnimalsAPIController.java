package com.example.demo.AnimalsAPI.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.AnimalsAPI.data.AnimalsAPI;
import com.example.demo.AnimalsAPI.service.AnimalsAPIService;

@Controller
public class AnimalsAPIController {

	private final AnimalsAPIService animalsAPIService;

	public AnimalsAPIController(AnimalsAPIService animalsAPIService) {
		this.animalsAPIService = animalsAPIService;
	}

	@GetMapping("/animalsAPI")
	public String getPets(Model model) throws IOException {

		List<AnimalsAPI> animalsList = animalsAPIService.getAnimals();

		model.addAttribute("animalsList", animalsList);

		return "animalsSearch.html";

	}

	@PostMapping("/animalsAPI")
	public String getAnimalInformation(@RequestParam("select") String option, Model model) throws IOException {

		AnimalsAPI animal = animalsAPIService.getAnimalInformation(option);

		model.addAttribute("animal", animal);

		return "animalsDetail.html";

	}

}