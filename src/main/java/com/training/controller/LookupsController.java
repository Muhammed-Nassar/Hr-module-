package com.training.controller;

import com.training.entity.Countries;
import com.training.entity.Departments;
import com.training.service.CountryService;
import com.training.service.DepartmentService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lookup")
public class LookupsController {
    @Autowired
    CountryService countryService;
    @Autowired
    DepartmentService departmentService;

    @GetMapping("/countries")
    @ApiOperation(value = "VIEW LIST OF COUNTRY" ,response = Countries.class)
    //Another solution for mapping
    @RequestMapping(method = RequestMethod.GET)
    public List<Countries> getCountryList() {
        return countryService.getList();

    }

    @GetMapping("/searchcountry/{name}")
    public List<Countries> searchCountry(@PathVariable String name) {
        return countryService.findByName(name);
    }

    @PostMapping("/countries")
    public String addCountry() {
        countryService.addNew();
        return "Added Successfully";
    }

    @DeleteMapping("/countries")
    public String deleteCountry(@RequestParam String id) {
        countryService.delete(id);
        return "deleted Successfully";
    }

    @PutMapping("/countries")
    public String updateCountry(@RequestBody Countries countries) {

        countryService.update(countries);
        return "updated Successfully";
    }

    @GetMapping("/find")
    public Countries getDepartmentById(@RequestParam String id) {
        return countryService.findById(id);

    }

    @GetMapping("/departments")
    public List<Departments> getDepartmentList() {
        return departmentService.getList();
    }

}
