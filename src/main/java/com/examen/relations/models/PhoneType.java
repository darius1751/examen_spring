package com.examen.relations.models;

import jakarta.persistence.*;

@Entity
public class PhoneType {

    private PhoneType(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @Column(unique = true)
    public String type;

    public static PhoneType createPhoneType(Integer id){
        final PhoneType phoneType = new PhoneType();
        phoneType.setId(id);
        return phoneType;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
