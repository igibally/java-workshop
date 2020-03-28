package com.test.javaworkshop.service;

import com.test.javaworkshop.dao.CountryDao;
import com.test.javaworkshop.exception.CountryNotFoundException;

public interface ICountryDetailsService {

	CountryDao findByCountryCode(String contryCode) throws CountryNotFoundException;

}
