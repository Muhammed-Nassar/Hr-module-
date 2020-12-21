package com.training.repository;

import com.training.entity.Countries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepo  extends JpaRepository<Countries,String> {
//Custom method using attribute must be exist in the entity (the same name "countryName")
    public List<Countries> findByCountryName(String countryName);
    }

