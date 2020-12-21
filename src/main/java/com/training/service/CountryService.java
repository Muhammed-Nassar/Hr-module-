package com.training.service;

import com.training.entity.Countries;
import com.training.entity.Locations;
import com.training.entity.Regions;
import com.training.repository.CountryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class CountryService {
    @Autowired
    private CountryRepo countryRepo;

    public void addNew() {
        Set<Locations> locations = new HashSet<>();
        locations.add(new Locations());
        Countries countries= new Countries("NA", new Regions(2), "nassarCountry",locations );
        countryRepo.save(countries);
    }

    public void update(Countries countries) {

        countryRepo.save(countries);
    }

    public void delete(String id) {

        countryRepo.deleteById(id);
    }

    public Countries findById(String id) {
        return countryRepo.findById(id).orElseThrow(null);

    }

    public List<Countries> findByName(String name) {
        return countryRepo.findByCountryName(name);
    }

    public List<Countries> getList() {
        return countryRepo.findAll();
    }


}
