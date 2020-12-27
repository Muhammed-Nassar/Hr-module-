package com.training.hr.controller;

import com.training.hr.entity.Country;
import com.training.hr.entity.Department;
import com.training.hr.service.DepartmentService;
import com.training.hr.service.CountryService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lookups")
public class LookupsController {
    @Autowired
    CountryService countryService;
    @Autowired
    DepartmentService departmentService;

    @GetMapping("/countries")
    @ApiOperation(value = "VIEW LIST OF COUNTRY", response = Country.class)
    public List<Country> getCountryList() {
        return countryService.getList();

    }


    @GetMapping("/countries/{id}")
    public Country getCountryByID(@PathVariable String id) {
        return countryService.findById(id);
    }

    @GetMapping("/countries/search/{name}")
    public List<Country> searchCountry(@PathVariable String name) {

        return countryService.findByName(name);
    }

    @PostMapping("/countries")
    public ResponseEntity<Country> addCountry(@RequestBody Country country) {
        countryService.addCountry(country);
        return new ResponseEntity<Country>(country, HttpStatus.OK);

    }

    @DeleteMapping("/countries")
    public void deleteCountry(@RequestParam String id) {

        countryService.deleteCountry(id);
    }

    @PutMapping("/countries")
    public ResponseEntity<Country> updateCountry(@RequestBody Country country) {

        countryService.updateCountry(country);
        return new ResponseEntity<Country>(country, HttpStatus.OK);
    }


    @GetMapping("/departments")
    public List<Department> getDepartmentList() {

        return departmentService.getList();
    }

    @GetMapping("/departments/search/{name}")
    public List<Department> searchDepartment(@PathVariable String name) {
        return departmentService.findByName(name);
    }

    @GetMapping("/departments/{id}")
    public ResponseEntity<Department> findByDepartmentId(@PathVariable int id) {
        return  new ResponseEntity(departmentService.findById(id),HttpStatus.OK);
    }

    @PostMapping("/departments")
    public Department addDepartment(@RequestBody Department department) {
        return departmentService.addDepartment(department);

    }

    @PutMapping("/departments")
    public Department updateDepartment(@RequestBody Department department) {
        return departmentService.updateDepartment(department);
    }

    @DeleteMapping("/departments")
    public void deleteByDepartmentId(@RequestParam int id) {
        departmentService.deleteById(id);
    }
//    @DeleteMapping("/departments")
//    public void deleteByDepartment(@RequestBody Departments department){
//        departmentService.deleteByDepartment(department);
//    }
//Spring Rest Request validation
//Add @Validated in request params


}
