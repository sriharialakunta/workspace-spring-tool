package com.example.demo.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@EnableAutoConfiguration(exclude=SecurityAutoConfiguration.class)
@WebMvcTest(ProductController.class)
class ProductControllerTest {
	
			@Autowired
			private MockMvc mockMvc;

			@MockBean
			private ProductController service;

			@Test
			public void returnValueFromService() throws Exception {
				when(service.count()).thenReturn(29);
				this.mockMvc.perform(get("/countProduct")).andDo(print()).andExpect(status().isOk())
						.andExpect(content().json("29"));
			
		}

}
