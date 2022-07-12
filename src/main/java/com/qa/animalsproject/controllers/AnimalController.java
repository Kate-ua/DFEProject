package com.qa.animalsproject.controllers;

import java.util.List;

@RestController
@RestMapping("/animals")
public class AnimalController {
	
	

@GetMapping("/readAll")
public List<Animals>readAll(){
	
}

@GetMapping("/readById/{id}")
public Animals readbyId(@PathVariable long id) {
	
}

@GetMapping("readByType/{type}")
public List<Animals> readByType(@PathVariable String type){
	
}

@PostMapping("/create")
public Animals create(@RequestBody Animals animals) {
	
}

@PutMapping("/update/{id}")
public Animals updateAnimals(@PathVariable long id, @RequestBody Animals animals) {
	
}
@DeleteMapping("/delete/{id}")
public boolean delete(@PathVariable long id) {
	
}
}