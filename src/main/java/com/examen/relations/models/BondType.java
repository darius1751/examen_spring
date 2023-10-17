package com.examen.relations.models;

import jakarta.persistence.*;

@Entity
public class BondType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "type")
    private String bond;
}
