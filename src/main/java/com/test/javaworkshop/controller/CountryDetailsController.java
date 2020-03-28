package com.test.javaworkshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.test.javaworkshop.dao.CountryDao;
import com.test.javaworkshop.dto.CountryDetailsDTO;
import com.test.javaworkshop.exception.CountryNotFoundException;
import com.test.javaworkshop.mapper.CountryDetailsMapper;
import com.test.javaworkshop.service.ICountryDetailsService;

@RestController
public class CountryDetailsController {

	private final ICountryDetailsService countryDetailsService;

	@Autowired
	public CountryDetailsController(final ICountryDetailsService countryDetailsService) {
		this.countryDetailsService = countryDetailsService;
	}

	/**
	 * APi for retrieving Country with /{Code}
	 * 
	 * @param countryCode
	 * @return CountryDTO
	 * @throws CountryNotFoundException
	 */
	@GetMapping("/{contryCode}")
	public CountryDetailsDTO getProduct(@PathVariable String contryCode) throws CountryNotFoundException {

		CountryDao CountryDoa = countryDetailsService.findByCountryCode(contryCode);

		return CountryDetailsMapper.makeCountryDTO(CountryDoa);
	}

	@GetMapping("/checkCodeHelth")
	public String getProduct() {
		return "the application is working fine";
	}
}
