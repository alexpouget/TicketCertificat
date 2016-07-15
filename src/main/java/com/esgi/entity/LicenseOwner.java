package com.esgi.entity;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by alex on 29/05/2016.
 */
@Entity
@Table(name = "license_owner")
public class LicenseOwner implements Serializable {

    public LicenseOwner() {
    }

    public LicenseOwner(String dateDebut, String dateExpiration, Computer computer, Company company, License license) {
        this.dateDebut = dateDebut;
        this.dateExpiration = dateExpiration;
        this.computer = computer;
        this.company = company;
        this.license = license;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(String dateDebut) {
        this.dateDebut = dateDebut;
    }

    public String getDateExpiration() {
        return dateExpiration;
    }

    public void setDateExpiration(String dateExpiration) {
        this.dateExpiration = dateExpiration;
    }

    public Computer getComputer() {
        return computer;
    }

    public void setComputer(Computer computer) {
        this.computer = computer;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public License getLicense() {
        return license;
    }

    public void setLicense(License license) {
        this.license = license;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "date_debut")
    private String dateDebut;

    @Column(name = "date_expiration")
    private String dateExpiration;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "id_computer")
    private Computer computer;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "id_company")
    private Company company;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "id_license")
    private License license;

}
