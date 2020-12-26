package com.training.hr.entity;



import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="countries"
        ,catalog="hr"
)

public class Country implements java.io.Serializable {


    private String countryId;
    private Region region;
    private String countryName;
    private Set<Location> locations = new HashSet<Location>(0);

    public Country() {
    }


    public Country(String countryId, Region region) {
        this.countryId = countryId;
        this.region = region;
    }
    public Country(String countryId, Region region, String countryName, Set<Location> locations) {
        this.countryId = countryId;
        this.region = region;
        this.countryName = countryName;
        this.locations = locations;
    }

    @Id


    @Column(name="country_id", unique=true, nullable=false, length=2)
    public String getCountryId() {
        return this.countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="region_id", nullable=false)
    public Region getRegions() {
        return this.region;
    }

    public void setRegions(Region region) {
        this.region = region;
    }


    @Column(name="country_name", length=40)
    public String getCountryName() {
        return this.countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="countries")
    public Set<Location> getLocationses() {
        return this.locations;
    }

    public void setLocationses(Set<Location> locations) {
        this.locations = locations;
    }




}
