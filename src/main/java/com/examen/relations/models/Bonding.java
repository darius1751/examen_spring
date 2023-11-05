package com.examen.relations.models;

import jakarta.persistence.*;

@Entity
@Table(
        indexes = {
            @Index(columnList ="type, binding_id, bound_id", unique = true)
        }
)
public class Bonding {

    private Bonding(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(targetEntity = BondType.class)
    @JoinColumn(name = "type", nullable = false)
    //@ColumnDefault(value = "1") //1. Sin Vinculos
    private BondType bondType;

    @ManyToOne(targetEntity = Person.class)
    @JoinColumn(nullable = true)
    private Person binding;

    @ManyToOne(targetEntity = Person.class)
    @JoinColumn(nullable = false)
    private Person bound;


    public static Bonding createBonding(Person binding, Person bound, BondType bondType){
        final Bonding bonding = new Bonding();
        bonding.setBinding(binding);
        bonding.setBound(bound);
        bonding.setBondType(bondType);
        return bonding;
    }

    public static Bonding probeBonding(Person binding){
        final Bonding bonding = new Bonding();
        bonding.setBinding(binding);
        return bonding;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BondType getBondType() {
        return bondType;
    }

    public void setBondType(BondType bondType) {
        this.bondType = bondType;
    }

    public Person getBinding() {
        return binding;
    }

    public void setBinding(Person binding) {
        this.binding = binding;
    }

    public Person getBound() {
        return bound;
    }

    public void setBound(Person bound) {
        this.bound = bound;
    }
}
