package com.test.javaworkshop.domainobject;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.javaworkshop.dao.CountryDao;

@Repository
public interface CountryRepository extends JpaRepository<CountryDao, Long> {

	CountryDao findByCode(String contryCode);

}
