package com.examen.relations.models;

import com.examen.relations.dto.person.CreatePersonDto;
import jakarta.persistence.*;

@Entity
public class Person {

    private Person(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    public static Person createPerson(CreatePersonDto createPersonDto){ // FactoryConstructor
        final Person person = new Person();
        person.setName(createPersonDto.getName());
        return person;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
