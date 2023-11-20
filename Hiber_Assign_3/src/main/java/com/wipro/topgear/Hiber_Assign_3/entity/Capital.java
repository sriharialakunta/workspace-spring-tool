package com.wipro.topgear.Hiber_Assign_3.entity;


import javax.persistence.Embeddable;

@Embeddable
public class Capital {
    private String capName;

    public Capital() {}

    public Capital(String name) {
        this.capName = name;
    }

    public String getName() {
        return capName;
    }

    public void setName(String name) {
        this.capName = name;
    }
}
