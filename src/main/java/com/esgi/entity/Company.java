package com.esgi.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by alex on 29/05/2016.
 */
@Entity
@Table(name = "company")
public class Company implements Serializable {

    public Company() {
    }

    public Company(String name, String adress){
        this.name = name;
        this.adress = adress;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "adress")
    private String adress;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL,mappedBy="company")
    private Set<LicenseOwner> licenseOwners;

}
