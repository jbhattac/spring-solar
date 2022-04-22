package com.jb.springsolar.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest(value = "SpringSolarApplication.class")
@AutoConfigureMockMvc
public class ProductControllerTest {

	@Autowired
	private MockMvc mvc;

	@Test
	public void testAddProduct_validProduct() throws Exception {
		String jsonContent="{\"sku\":\"article123\","
				+ "\"detail\":{\"title\":\"best article ever\",\"description\":\"An astonishing article with unsurplussed features.\",\"price\":3.33,\"currency\":\"USD\"}}";
		
		mvc.perform(post("/api/product/add")
				.content(jsonContent)
				.contentType(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().is2xxSuccessful())
				.andExpect(MockMvcResultMatchers.jsonPath("$.sku").value("article123"));
	}
	
	@Test
	public void testGetProduct_invalidvalidProduct() throws Exception {
			mvc.perform(get("/api/products/detail/{sku}", "invalidsku")
				.contentType(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().is4xxClientError())
				;
	}

}
