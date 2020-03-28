package com.test.javaworkshop.dao;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "city", uniqueConstraints = @UniqueConstraint(columnNames = "id", name = "city_pkey"))
public class CityDao {
	@Id()
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "name", nullable = false, columnDefinition = "TEXT NOT NULL")
	private String name;

	@OneToOne(mappedBy = "capital", cascade = CascadeType.ALL)
	private CountryDao country_code;

	@Column(name = "district", nullable = false, columnDefinition = "TEXT NOT NULL")
	private String district;

	@Column(name = "population", nullable = false)
	private Integer population;

	public CityDao() {
	}

	public String getName() {
		return name;
	}

	public CityDao(String name, CountryDao country_code, String district, Integer population) {
		super();
		this.name = name;
		this.country_code = country_code;
		this.district = district;
		this.population = population;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CountryDao getCountry_code() {
		return country_code;
	}

	public void setCountry_code(CountryDao country_code) {
		this.country_code = country_code;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public Integer getPopulation() {
		return population;
	}

	public void setPopulation(Integer population) {
		this.population = population;
	}

	public Long getId() {
		return id;
	}

}
