package com.training.hr.repository;

import com.training.hr.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepo  extends JpaRepository<Country,String> {
//Custom method using attribute must be exist in the entity (the same name "countryName")
    public List<Country> findByCountryName(String countryName);
    }

