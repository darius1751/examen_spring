package com.examen.relations.models;

import jakarta.persistence.*;

@Entity
public class AddressType {

    private AddressType(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @Column(unique = true)
    public String type;

    public static AddressType createAddressType(Integer id){
        final AddressType addressType = new AddressType();
        addressType.setId(id);
        return addressType;
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
