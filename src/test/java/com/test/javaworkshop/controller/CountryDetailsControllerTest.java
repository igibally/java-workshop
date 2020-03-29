package com.test.javaworkshop.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.test.javaworkshop.exception.CountryNotFoundException;
import com.test.javaworkshop.exception.DataBaseNotAvailableException;
import com.test.javaworkshop.service.impl.CountryDetailsService;

import enums.ErrorResponseEnum;

@ExtendWith(SpringExtension.class)
@WebMvcTest(CountryDetailsController.class)
@ContextConfiguration(classes = AppConfig.class)
class CountryDetailsControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	CountryDetailsService countryDetailsService;

	@Test
	void testgetCountryNonCodeExist() throws Exception {

		String worngCode = "wrngcode";
		Mockito.when(countryDetailsService.findByCountryCode(worngCode)).thenThrow(new CountryNotFoundException(ErrorResponseEnum.INVALID_COUNTRY_CODE.name()));
		String URI = "/" + worngCode;
		mockMvc.perform(MockMvcRequestBuilders.get(URI).accept(MediaType.APPLICATION_JSON)).andExpect(status().is5xxServerError()).andExpect(MockMvcResultMatchers.jsonPath("$.message").value(ErrorResponseEnum.INVALID_COUNTRY_CODE.name()));
	}

	@Test
	void testgetCountryDatabaseDown() throws Exception {

		String Code = "wrngcode";
		Mockito.when(countryDetailsService.findByCountryCode(Mockito.anyString())).thenThrow(new DataBaseNotAvailableException(ErrorResponseEnum.INTERNAL_ERROR.name()));
		String URI = "/" + Code;
		mockMvc.perform(MockMvcRequestBuilders.get(URI).accept(MediaType.APPLICATION_JSON)).andExpect(status().is5xxServerError()).andExpect(MockMvcResultMatchers.jsonPath("$.message").value(ErrorResponseEnum.INTERNAL_ERROR.name()));
	}

}
