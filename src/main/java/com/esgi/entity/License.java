package com.esgi.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by alex on 29/05/2016.
 */
@Entity
@Table(name = "license")
public class License implements Serializable {

    public License() {
    }

    public License(TypeLicense typeLicense, Software software) {
        this.typeLicense = typeLicense;
        this.software = software;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TypeLicense getTypeLicense() {
        return typeLicense;
    }

    public void setTypeLicense(TypeLicense typeLicense) {
        this.typeLicense = typeLicense;
    }

    public Software getSoftware() {
        return software;
    }

    public void setSoftware(Software software) {
        this.software = software;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "type_license")
    private TypeLicense typeLicense;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "id_software")
    private Software software;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL,mappedBy="license")
    private Set<LicenseOwner> licenseOwners;
}
