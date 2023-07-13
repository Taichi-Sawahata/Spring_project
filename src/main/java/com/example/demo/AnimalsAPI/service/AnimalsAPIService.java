package com.example.demo.AnimalsAPI.service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.AnimalsAPI.data.AnimalsAPI;
import com.example.demo.AnimalsAPI.repository.AnimalsAPIRepository;

@Service
public class AnimalsAPIService {

	private final AnimalsAPIRepository animalsAPIRepository;

	public AnimalsAPIService(AnimalsAPIRepository animalsAPIRepository) {
		this.animalsAPIRepository = animalsAPIRepository;
	}

	public List<AnimalsAPI> getAnimals() throws IOException {

		AnimalsAPI[] animalsList = getAnimalsData();

		return Arrays.asList(animalsList);

	}

	public AnimalsAPI getAnimalInformation(String option) throws IOException {

		AnimalsAPI[] animalsList = getAnimalsData();

		for (AnimalsAPI animal : animalsList) {
			if (animal.getJapaneseName().equals(option)) {
				return animal;
			}
		}

		return null;

	}

	private AnimalsAPI[] getAnimalsData() throws IOException {
		return animalsAPIRepository.getAnimals();
	}

}