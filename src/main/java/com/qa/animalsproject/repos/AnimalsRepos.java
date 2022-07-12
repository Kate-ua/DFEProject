package com.qa.animalsproject.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.animalsproject.entities.Animals;

@Repository
public interface AnimalsRepos extends JpaRepository<Animals, Long> {

	List<Animals> findAnimalsByType(String type);

}
