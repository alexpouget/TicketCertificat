package com.esgi.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by alex on 29/05/2016.
 */
@Entity
@Table(name = "user")
public class User implements Serializable {

    public User() {
    }

    public User(String uid, String password, String email, Company company) {
        this.uid = uid;
        this.password = password;
        this.email = email;
        this.company = company;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "uid")
    private String uid;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "id_company")
    private Company company;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL,mappedBy="user")
    private List<UserRole> userRoles;
}
