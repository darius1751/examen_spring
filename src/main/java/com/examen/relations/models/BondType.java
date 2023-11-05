package com.examen.relations.models;

import jakarta.persistence.*;

@Entity
public class BondType {

    private BondType(){}
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "type")
    private String bond;

    public static BondType createBondType(Integer id){
        BondType bondType = new BondType();
        bondType.setId(id);
        return bondType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBond() {
        return bond;
    }

    public void setBond(String bond) {
        this.bond = bond;
    }
}
