package com.github.piotryuxuan.springbootplayground.api;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class ApiControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testGetAnswer() throws Exception {
		mockMvc.perform(get("/api/v1/answer")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().json("[42]"));
	}

	@Test
	public void testGetAddition() throws Exception {
		mockMvc.perform(get("/api/v1/addition")
				.contentType(MediaType.APPLICATION_JSON)
				.param("a", "3")
				.param("b", "3"))
				.andExpect(status().isOk())
				.andExpect(content().json("6"));
	}

}
