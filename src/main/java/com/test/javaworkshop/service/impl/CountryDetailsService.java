package com.test.javaworkshop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.javaworkshop.dao.CountryDao;
import com.test.javaworkshop.domainobject.CountryRepository;
import com.test.javaworkshop.exception.CountryNotFoundException;
import com.test.javaworkshop.exception.DataBaseNotAvailableException;
import com.test.javaworkshop.service.ICountryDetailsService;

@Service
public class CountryDetailsService implements ICountryDetailsService {

	@Autowired
	CountryRepository CountryRepo;

	@Override
	public CountryDao findByCountryCode(String contryCode) throws CountryNotFoundException, DataBaseNotAvailableException {

		return CountryRepo.findByCode(contryCode);
	}

}
