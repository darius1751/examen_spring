package com.examen.relations.models;

import com.examen.relations.dto.country.CreateCountryDto;
import com.examen.relations.dto.country.ReferenceCountryDto;
import com.examen.relations.dto.country.UpdateCountryDto;
import jakarta.persistence.*;

@Entity
public class Country {

    private Country(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String name;

    public static Country createCountry(CreateCountryDto createCountryDto){
        Country country = new Country();
        country.setName(createCountryDto.getName());
        return country;
    }

    public static Country createReferenceCountry(ReferenceCountryDto referenceCountryDto){
        Country country = new Country();
        country.setId(referenceCountryDto.getId());
        return country;
    }

    public static Country updateCountry(Integer id, UpdateCountryDto updateCountryDto){
        Country country = new Country();
        country.setId(id);
        country.setName(updateCountryDto.getName());
        return country;
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
