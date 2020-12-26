package com.training.hr.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="regions"
        ,catalog="hr"
)
public class Region implements java.io.Serializable {


    private int regionId;
    private String regionName;
    private Set<Country> countrieses = new HashSet<Country>(0);

    public Region() {
    }


    public Region(int regionId) {
        this.regionId = regionId;
    }
    public Region(int regionId, String regionName, Set<Country> countrieses) {
        this.regionId = regionId;
        this.regionName = regionName;
        this.countrieses = countrieses;
    }

    @Id


    @Column(name="region_id", unique=true, nullable=false)
    public int getRegionId() {
        return this.regionId;
    }

    public void setRegionId(int regionId) {
        this.regionId = regionId;
    }


    @Column(name="region_name", length=25)
    public String getRegionName() {
        return this.regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="regions")
    public Set<Country> getCountrieses() {
        return this.countrieses;
    }

    public void setCountrieses(Set<Country> countrieses) {
        this.countrieses = countrieses;
    }




}
