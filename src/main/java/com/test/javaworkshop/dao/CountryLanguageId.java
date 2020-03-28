package com.test.javaworkshop.dao;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

@Embeddable
public class CountryLanguageId implements Serializable {

	private static final long serialVersionUID = 1292635446864397665L;

	@Column(name = "language", nullable = false, columnDefinition = "text NOT NULL")
	private String language;

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
	@JoinColumns({ @JoinColumn(name = "country_code", referencedColumnName = "code") })
	private CountryDao country_code;

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public CountryDao getCountry_code() {
		return country_code;
	}

	public void setCountry_code(CountryDao country_code) {
		this.country_code = country_code;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((country_code == null) ? 0 : country_code.hashCode());
		result = prime * result + ((language == null) ? 0 : language.hashCode());
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
		CountryLanguageId other = (CountryLanguageId) obj;
		if (country_code == null) {
			if (other.country_code != null)
				return false;
		} else if (!country_code.equals(other.country_code))
			return false;
		if (language == null) {
			if (other.language != null)
				return false;
		} else if (!language.equals(other.language))
			return false;
		return true;
	}

}
