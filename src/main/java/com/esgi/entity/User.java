package com.esgi.entity;


import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by alex on 29/05/2016.
 */
@Entity
@Table(name = "user")
public class User implements Serializable {

    public User() {
    }

    public User(String uid, String password, String email) {
        this.uid = uid;
        this.password = password;
        this.email = email;
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

}
