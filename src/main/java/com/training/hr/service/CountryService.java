package com.training.hr.service;

import com.training.hr.entity.Country;
import com.training.hr.repository.CountryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {
    @Autowired
    private CountryRepo countryRepo;

    public Country addCountry(Country country) {

       return  countryRepo.save(country);
    }

    public Country updateCountry(Country country) {

       return countryRepo.save(country);
    }

    public void deleteCountry(String id) {

        countryRepo.deleteById(id);
    }

    public Country findById(String id) {
        return countryRepo.findById(id).orElseThrow(null);

    }

    public List<Country> findByName(String name) {

        return countryRepo.findByCountryName(name);
    }

    public List<Country> getList() {

        return countryRepo.findAll();
    }


}
