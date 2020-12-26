package com.training.hr.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name="locations"
        ,catalog="hr"
)
public class Location implements java.io.Serializable {


    private Integer locationId;
    private Country country;
    private String streetAddress;
    private String postalCode;
    private String city;
    private String stateProvince;
    private Set<Department> departments = new HashSet<Department>(0);

    public Location() {
    }


    public Location(Country country, String city) {
        this.country = country;
        this.city = city;
    }
    public Location(Country country, String streetAddress, String postalCode, String city, String stateProvince, Set<Department> departments) {
        this.country = country;
        this.streetAddress = streetAddress;
        this.postalCode = postalCode;
        this.city = city;
        this.stateProvince = stateProvince;
        this.departments = departments;
    }

    @Id
    @GeneratedValue(strategy=IDENTITY)


    @Column(name="location_id", unique=true, nullable=false)
    public Integer getLocationId() {
        return this.locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="country_id", nullable=false)
    public Country getCountries() {
        return this.country;
    }

    public void setCountries(Country country) {
        this.country = country;
    }


    @Column(name="street_address", length=40)
    public String getStreetAddress() {
        return this.streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }


    @Column(name="postal_code", length=12)
    public String getPostalCode() {
        return this.postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }


    @Column(name="city", nullable=false, length=30)
    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }


    @Column(name="state_province", length=25)
    public String getStateProvince() {
        return this.stateProvince;
    }

    public void setStateProvince(String stateProvince) {
        this.stateProvince = stateProvince;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="locations")
    public Set<Department> getDepartmentses() {
        return this.departments;
    }

    public void setDepartmentses(Set<Department> departments) {
        this.departments = departments;
    }




}

