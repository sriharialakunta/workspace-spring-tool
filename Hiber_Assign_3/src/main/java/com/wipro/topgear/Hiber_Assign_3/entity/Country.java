package com.wipro.topgear.Hiber_Assign_3.entity;

import javax.persistence.Embeddable;

@Embeddable
public class Country {
    private String name;

    public Country() {}

    public Country(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

