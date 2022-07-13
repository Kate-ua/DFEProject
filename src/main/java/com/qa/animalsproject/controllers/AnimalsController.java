package com.qa.animalsproject.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.animalsproject.entities.Animals;
import com.qa.animalsproject.services.AnimalsService;

@RestController
@RequestMapping("/animals")
public class AnimalsController {

	private AnimalsService service;

	public AnimalsController(AnimalsService service) {
		this.service=service;
	}

	@GetMapping("/readAll")
	public List<Animals> readAll() {
		return this.service.readAll();

	}

	@GetMapping("/readById/{id}")
	public Animals readbyId(@PathVariable long id) {
		return this.service.readById(id);

	}

	@GetMapping("readByType/{type}")
	public List<Animals> readByType(@PathVariable String type) {
		return this.service.readByType(type);

	}

	@PostMapping("/create")
	public Animals create(@RequestBody Animals animals) {
		return this.service.create(animals);

	}

	@PutMapping("/update/{id}")
	public Animals updateAnimals(@PathVariable long id, @RequestBody Animals animals) {
		return this.service.update(id, animals);

	}

	@DeleteMapping("/delete/{id}")
	public boolean delete(@PathVariable long id) {
		return this.service.delete(id);

	}
}