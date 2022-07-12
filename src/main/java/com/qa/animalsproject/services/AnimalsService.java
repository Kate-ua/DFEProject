package com.qa.animalsproject.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.animalsproject.entities.Animals;
import com.qa.animalsproject.repos.AnimalsRepos;

@Service
public class AnimalsService {
	
	private AnimalsRepos repos;
	
	public AnimalsService(AnimalsRepos repos) {
		this.repos = repos;
	}
	
	public Animals create(Animals animals) {
		return this.repos.saveAndFlush(animals);
	}
	
	public List<Animals>readAll(){
		return this.repos.findAll();
	}
	
	public Animals readById(long id) {
		return this.repos.findById(id).get();
		
	}
	
	public List<Animals>readByType(String type){
		return this.repos.findAnimalsByType(type);
		
	}
	
	public Animals update(long id, Animals animals) {
		Animals existing = this.repos.findById(id).get();
		existing.setType(animals.getType());
		existing.setHabitat(animals.getHabitat());
		existing.setAge(animals.getAge());
		existing.setNumOfLegs(animals.getNumOfLegs());
		return this.repos.saveAndFlush(existing);
		
	}
	
	public boolean delete(long id) {
		this.repos.deleteById(id);
		return !this.repos.existsById(id);
		
	}
	
}
