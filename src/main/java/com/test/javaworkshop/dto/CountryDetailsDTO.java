package com.test.javaworkshop.dto;

import java.util.List;

import org.springframework.stereotype.Component;

import enums.ContinentEnum;

@Component
public class CountryDetailsDTO {

	private String name;
	private ContinentEnum continent;
	private Integer population;
	private Float life_expectancy;
	List<String> languages;

	private CountryDetailsDTO() {

	}

	private CountryDetailsDTO(String name, ContinentEnum continent, Integer population, Float life_expectancy, List<String> languages) {

		this.name = name;
		this.continent = continent;
		this.population = population;
		this.life_expectancy = life_expectancy;
		this.languages = languages;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ContinentEnum getContinent() {
		return continent;
	}

	public void setContinent(ContinentEnum continent) {
		this.continent = continent;
	}

	public Integer getPopulation() {
		return population;
	}

	public void setPopulation(Integer population) {
		this.population = population;
	}

	public Float getLife_expectancy() {
		return life_expectancy;
	}

	public void setLife_expectancy(Float life_expectancy) {
		this.life_expectancy = life_expectancy;
	}

	public List<String> getLanguages() {
		return languages;
	}

	public void setLanguages(List<String> languages) {
		this.languages = languages;
	}

	public static CountryDetailsDTOBuilder newBuilder() {
		return new CountryDetailsDTOBuilder();
	}

	public static class CountryDetailsDTOBuilder {

		private String name;
		private ContinentEnum continent;
		private Integer population;
		private Float life_expectancy;
		List<String> languages;

		public CountryDetailsDTOBuilder setName(String Name) {
			this.name = Name;
			return this;
		}

		public CountryDetailsDTOBuilder setPopulation(Integer population) {
			this.population = population;
			return this;
		}

		public CountryDetailsDTOBuilder setContinent(ContinentEnum continent) {
			this.continent = continent;
			return this;
		}

		public CountryDetailsDTOBuilder setlifeExpectancy(Float life_expectancy) {
			this.life_expectancy = life_expectancy;
			return this;
		}

		public CountryDetailsDTOBuilder setlanguages(List<String> languages) {
			this.languages = languages;
			return this;
		}

		public CountryDetailsDTO createCountryDetailsDTO() {
			return new CountryDetailsDTO(this.name, this.continent, this.population, this.life_expectancy, this.languages);
		}
	}
}
