package com.wongnai.interview.movie;

import java.util.Arrays;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
public class MoviesControllerIntegrationTest extends BaseIntegrationTest {
	@Autowired
	private MockMvc mvc;

	@Test
	public void testSearchWithRestApi() throws Exception {
		mvc.perform(get("/movies/search?q=Glorious"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$").isArray())
				.andExpect(jsonPath("$.length()", Matchers.equalTo(7)))
				.andExpect(jsonPath("$[?(@.name == 'The Glorious Fool')].actors[*]",
						Matchers.equalTo(Arrays.asList("Helene Chadwick", "Richard Dix"))));
	}
}
