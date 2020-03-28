package com.test.javaworkshop.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.test.javaworkshop.dao.CountryDao;
import com.test.javaworkshop.dao.CountryLanguageDao;
import com.test.javaworkshop.dto.CountryDetailsDTO;

@Component
public class CountryDetailsMapper {

	public static CountryDetailsDTO makeCountryDTO(CountryDao countryDao)

	{

		CountryDetailsDTO countryDetailsDTO = CountryDetailsDTO.newBuilder().setName(countryDao.getName()).setContinent(countryDao.getContinent()).setlifeExpectancy(countryDao.getLife_expectancy()).setPopulation(countryDao.getPopulation())
				.setlanguages(makeLanguagesList(countryDao.getCountryLanguages())).createCountryDetailsDTO();
		return countryDetailsDTO;

	}

	static List<String> makeLanguagesList(List<CountryLanguageDao> listDao) {
		List<String> languages = new ArrayList<String>(listDao.size());
		for (CountryLanguageDao item : listDao) {
			languages.add(item.getId().getLanguage());
		}
		return languages;
	}

}
