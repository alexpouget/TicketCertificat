package com.esgi.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by alex on 29/05/2016.
 */
@Entity
@Table(name = "role")
public class Role implements Serializable{

    public Role() {
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

    public Role(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

}
