package com.qa.animalsproject.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.animalsproject.entities.Animals;

@SpringBootTest
@AutoConfigureMockMvc
@Sql(scripts = { "classpath:testschema.sql",
		"classpath:testdata.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
public class AnimalsControllerTest {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private ObjectMapper mapper;

	@Test
	public void ReadAllTest() throws Exception {
		List<Animals> output = new ArrayList<>();
		Animals entry = new Animals(1L, "koala", 11, "open forest", 2);
		output.add(entry);

		String outputAsJSON = mapper.writeValueAsString(output);

		mvc.perform(get("/animals/readAll").contentType(MediaType.APPLICATION_JSON))
				.andExpect(content().json(outputAsJSON));
	}

	@Test
	public void readByIdTest() throws Exception {
		Animals entry = new Animals(1L, "koala", 11, "open forest", 2);

		String entryAsJSON = this.mapper.writeValueAsString(entry);

		mvc.perform(get("/animals/readById/1").contentType(MediaType.APPLICATION_JSON))
				.andExpect(content().json(entryAsJSON));

	}

	@Test
	public void readByTypeTest() throws Exception {
		List<Animals> output = new ArrayList<>();
		Animals entry = new Animals(1L, "koala", 11, "open forest", 2);
		output.add(entry);

		String outputAsJSON = mapper.writeValueAsString(output);

		mvc.perform(get("/animals/readByType/koala").contentType(MediaType.APPLICATION_JSON))
				.andExpect(content().json(outputAsJSON));
	}

	@Test
	public void createTest() throws Exception {
		Animals entry = new Animals("koala", 9, "open forest", 2);
		String entryAsJSON = this.mapper.writeValueAsString(entry);
		Animals result = new Animals(2L, "koala", 9, "open forest", 2);
		String resultAsJSON = this.mapper.writeValueAsString(result);

		mvc.perform(post("/animals/create").contentType(MediaType.APPLICATION_JSON).content(entryAsJSON))
				.andExpect(content().json(resultAsJSON));
	}

	@Test
	public void updateTest() throws Exception {
		Animals entry = new Animals("koala", 9, "open forest", 2);
		String entryAsJSON = this.mapper.writeValueAsString(entry);
		Animals result = new Animals(1L, "koala", 9, "open forest", 2);
		String resultAsJSON = this.mapper.writeValueAsString(result);

		mvc.perform(put("/animals/update/1").contentType(MediaType.APPLICATION_JSON).content(entryAsJSON))
				.andExpect(content().json(resultAsJSON));

	}
	
	@Test
	public void deleteTest() throws Exception {
		
		mvc.perform(delete("/animals/delete/1")
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(content().string("true"));
	}
}
