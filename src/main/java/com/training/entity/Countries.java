package com.training.entity;



import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="countries"
        ,catalog="hr"
)

public class Countries  implements java.io.Serializable {


    private String countryId;
    private Regions regions;
    private String countryName;
    private Set<Locations> locationses = new HashSet<Locations>(0);

    public Countries() {
    }


    public Countries(String countryId, Regions regions) {
        this.countryId = countryId;
        this.regions = regions;
    }
    public Countries(String countryId, Regions regions, String countryName, Set<Locations> locationses) {
        this.countryId = countryId;
        this.regions = regions;
        this.countryName = countryName;
        this.locationses = locationses;
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
    public Regions getRegions() {
        return this.regions;
    }

    public void setRegions(Regions regions) {
        this.regions = regions;
    }


    @Column(name="country_name", length=40)
    public String getCountryName() {
        return this.countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="countries")
    public Set<Locations> getLocationses() {
        return this.locationses;
    }

    public void setLocationses(Set<Locations> locationses) {
        this.locationses = locationses;
    }




}
