package com.training.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name="locations"
        ,catalog="hr"
)
public class Locations  implements java.io.Serializable {


    private Integer locationId;
    private Countries countries;
    private String streetAddress;
    private String postalCode;
    private String city;
    private String stateProvince;
    private Set<Departments> departmentses = new HashSet<Departments>(0);

    public Locations() {
    }


    public Locations(Countries countries, String city) {
        this.countries = countries;
        this.city = city;
    }
    public Locations(Countries countries, String streetAddress, String postalCode, String city, String stateProvince, Set<Departments> departmentses) {
        this.countries = countries;
        this.streetAddress = streetAddress;
        this.postalCode = postalCode;
        this.city = city;
        this.stateProvince = stateProvince;
        this.departmentses = departmentses;
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
    public Countries getCountries() {
        return this.countries;
    }

    public void setCountries(Countries countries) {
        this.countries = countries;
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
    public Set<Departments> getDepartmentses() {
        return this.departmentses;
    }

    public void setDepartmentses(Set<Departments> departmentses) {
        this.departmentses = departmentses;
    }




}

