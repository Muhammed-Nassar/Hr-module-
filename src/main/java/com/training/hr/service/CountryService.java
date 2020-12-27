package com.training.hr.service;

import com.training.hr.entity.Country;
import com.training.hr.exception.ResourceNotFoundException;
import com.training.hr.repository.CountryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CountryService {
    @Autowired
    private CountryRepo countryRepo;

    public Country addCountry(Country country) {

        return countryRepo.save(country);
    }

    public Country updateCountry(Country country) {

        return countryRepo.save(country);
    }

    public void deleteCountry(String id) {

        countryRepo.deleteById(id);
    }

    public Country findById(String id) {
        return countryRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Country not found  with id :" + id));

    }

    public List<Country> findByName(String name) {

        return countryRepo.findByCountryNameContaining(name);
    }

    public List<Country> getList() {

        return countryRepo.findAll();
    }


}
