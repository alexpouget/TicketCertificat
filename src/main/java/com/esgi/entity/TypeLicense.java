package com.esgi.entity;


import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by alex on 29/05/2016.
 */
@Entity
@Table(name = "type_license")
public class TypeLicense implements Serializable {

    public TypeLicense() {
    }

    public TypeLicense(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "type")
    private String type;



}
