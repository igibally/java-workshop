package com.test.javaworkshop.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.validator.constraints.Length;

import enums.ContinentEnum;

@Entity
@Table(name = "country", uniqueConstraints = @UniqueConstraint(columnNames = "code", name = "country_pkey"))
public class CountryDao {

	@Id
	@Column(name = "code", nullable = false, unique = true, length = 3)
	private String code;

	@Column(name = "name", nullable = false, columnDefinition = "TEXT NOT NULL")
	private String name;

	@Enumerated(EnumType.STRING)
	@Column(name = "continent", nullable = false, columnDefinition = "TEXT NOT NULL")
	private ContinentEnum continent;

	@Column(name = "region", nullable = false, columnDefinition = "TEXT NOT NULL")
	private String region;

	@Column(name = "surface_area", nullable = false, columnDefinition = "real NOT NULL")
	private Float surface_area;

	@Column(name = "indep_year", columnDefinition = "smallint")
	private Short indep_year;

	@Column(name = "population", nullable = false)
	private Integer population;

	@Column(name = "life_expectancy", columnDefinition = "real")
	private Float life_expectancy;

	@Length(min = 2, max = 10)
	@Column(name = "gnp")

	private BigDecimal gnp_old;
	@Length(min = 2, max = 10)
	@Column(name = "gnp_old")
	private BigDecimal gnp;

	@Column(name = "local_name", nullable = false, columnDefinition = "TEXT NOT NULL")
	private String local_name;

	@Column(name = "government_form", nullable = false, columnDefinition = "TEXT NOT NULL")
	private String government_form;

	@Column(name = "head_of_state", columnDefinition = "TEXT")
	private String head_of_state;

	@Column(name = "code2", nullable = false, length = 2)
	private String code2;

	@JoinColumn(name = "capital")
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private CityDao capital;

	public String getCode() {
		return code;
	}

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "id.country_code", fetch = FetchType.LAZY, orphanRemoval = true)
	private List<CountryLanguageDao> countryLanguages;

	public List<CountryLanguageDao> getCountryLanguages() {
		return countryLanguages;
	}

	public void setCountryLanguages(List<CountryLanguageDao> countryLanguages) {
		this.countryLanguages = countryLanguages;
	}

	public CountryDao() {
	}

	public CountryDao(String code, String name, ContinentEnum continent, String region, Float surface_area, Short indep_year, Integer population, Float life_expectancy, @Length(min = 2, max = 10) BigDecimal gnp_old, @Length(min = 2, max = 10) BigDecimal gnp, String local_name, String government_form,
			String head_of_state, String code2, CityDao capital) {
		super();
		this.code = code;
		this.name = name;
		this.continent = continent;
		this.region = region;
		this.surface_area = surface_area;
		this.indep_year = indep_year;
		this.population = population;
		this.life_expectancy = life_expectancy;
		this.gnp_old = gnp_old;
		this.gnp = gnp;
		this.local_name = local_name;
		this.government_form = government_form;
		this.head_of_state = head_of_state;
		this.code2 = code2;
		this.capital = capital;
	}

	public void setCode(String code) {
		this.code = code;
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

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public Float getSurface_area() {
		return surface_area;
	}

	public void setSurface_area(Float surface_area) {
		this.surface_area = surface_area;
	}

	public Short getIndep_year() {
		return indep_year;
	}

	public void setIndep_year(Short indep_year) {
		this.indep_year = indep_year;
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

	public BigDecimal getGnp_old() {
		return gnp_old;
	}

	public void setGnp_old(BigDecimal gnp_old) {
		this.gnp_old = gnp_old;
	}

	public BigDecimal getGnp() {
		return gnp;
	}

	public void setGnp(BigDecimal gnp) {
		this.gnp = gnp;
	}

	public String getLocal_name() {
		return local_name;
	}

	public void setLocal_name(String local_name) {
		this.local_name = local_name;
	}

	public String getGovernment_form() {
		return government_form;
	}

	public void setGovernment_form(String government_form) {
		this.government_form = government_form;
	}

	public String getHead_of_state() {
		return head_of_state;
	}

	public void setHead_of_state(String head_of_state) {
		this.head_of_state = head_of_state;
	}

	public String getCode2() {
		return code2;
	}

	public void setCode2(String code2) {
		this.code2 = code2;
	}

	public CityDao getCapital() {
		return capital;
	}

	public void setCapital(CityDao capital) {
		this.capital = capital;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((capital == null) ? 0 : capital.hashCode());
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((code2 == null) ? 0 : code.hashCode());
		result = prime * result + ((continent == null) ? 0 : continent.hashCode());
		result = prime * result + ((countryLanguages == null) ? 0 : countryLanguages.hashCode());
		result = prime * result + ((gnp == null) ? 0 : gnp.hashCode());
		result = prime * result + ((gnp_old == null) ? 0 : gnp_old.hashCode());
		result = prime * result + ((government_form == null) ? 0 : government_form.hashCode());
		result = prime * result + ((head_of_state == null) ? 0 : head_of_state.hashCode());
		result = prime * result + ((indep_year == null) ? 0 : indep_year.hashCode());
		result = prime * result + ((life_expectancy == null) ? 0 : life_expectancy.hashCode());
		result = prime * result + ((local_name == null) ? 0 : local_name.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((population == null) ? 0 : population.hashCode());
		result = prime * result + ((region == null) ? 0 : region.hashCode());
		result = prime * result + ((surface_area == null) ? 0 : surface_area.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CountryDao other = (CountryDao) obj;
		if (capital == null) {
			if (other.capital != null)
				return false;
		} else if (!capital.equals(other.capital))
			return false;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (code2 != other.code2)
			return false;
		if (continent != other.continent)
			return false;
		if (countryLanguages == null) {
			if (other.countryLanguages != null)
				return false;
		} else if (!countryLanguages.equals(other.countryLanguages))
			return false;
		if (gnp == null) {
			if (other.gnp != null)
				return false;
		} else if (!gnp.equals(other.gnp))
			return false;
		if (gnp_old == null) {
			if (other.gnp_old != null)
				return false;
		} else if (!gnp_old.equals(other.gnp_old))
			return false;
		if (government_form == null) {
			if (other.government_form != null)
				return false;
		} else if (!government_form.equals(other.government_form))
			return false;
		if (head_of_state == null) {
			if (other.head_of_state != null)
				return false;
		} else if (!head_of_state.equals(other.head_of_state))
			return false;
		if (indep_year == null) {
			if (other.indep_year != null)
				return false;
		} else if (!indep_year.equals(other.indep_year))
			return false;
		if (life_expectancy == null) {
			if (other.life_expectancy != null)
				return false;
		} else if (!life_expectancy.equals(other.life_expectancy))
			return false;
		if (local_name == null) {
			if (other.local_name != null)
				return false;
		} else if (!local_name.equals(other.local_name))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (population == null) {
			if (other.population != null)
				return false;
		} else if (!population.equals(other.population))
			return false;
		if (region == null) {
			if (other.region != null)
				return false;
		} else if (!region.equals(other.region))
			return false;
		if (surface_area == null) {
			if (other.surface_area != null)
				return false;
		} else if (!surface_area.equals(other.surface_area))
			return false;
		return true;
	}

}
