package com.qa.animalsproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
public class AnimalsProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnimalsProjectApplication.class, args);
	}

}
