package com.test.javaworkshop.dao;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "country_language", uniqueConstraints = @UniqueConstraint(columnNames = { "country_code", "language" }, name = "country_language_pkey"))
public class CountryLanguageDao {

	@EmbeddedId

	private CountryLanguageId id;
	@Column(name = "percentage", nullable = false, columnDefinition = "real NOT NULL")
	private Float percentage;

	@Column(name = "is_official", nullable = false)
	private boolean is_official;

	public CountryLanguageDao() {
	}

	public CountryLanguageDao(CountryLanguageId id, Float percentage, boolean is_official) {
		this.id = id;
		this.percentage = percentage;
		this.is_official = is_official;
	}

	public CountryLanguageId getId() {
		return id;
	}

	public void setId(CountryLanguageId id) {
		this.id = id;
	}

	public Float getPercentage() {
		return percentage;
	}

	public void setPercentage(Float percentage) {
		this.percentage = percentage;
	}

	public boolean isIs_official() {
		return is_official;
	}

	public void setIs_official(boolean is_official) {
		this.is_official = is_official;
	}

}
