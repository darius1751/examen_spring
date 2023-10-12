package com.examen.relations.models;

import com.examen.relations.dto.country.CreateCountryDto;
import com.examen.relations.dto.country.ReferenceCountryDto;
import com.examen.relations.dto.department.CreateDepartmentDto;
import com.examen.relations.dto.department.ReferenceDepartmentDto;
import jakarta.persistence.*;

@Entity
public class Department{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @ManyToOne(cascade = CascadeType.ALL, optional = false, targetEntity = Country.class)
    @JoinColumn(nullable = false)
    private Country country;

    private Department(){};

    public static Department createDepartment(CreateDepartmentDto createDepartmentDto){
        final Department department = new Department();
        department.setName(createDepartmentDto.getName());
        ReferenceCountryDto referenceCountryDto = new ReferenceCountryDto();
        referenceCountryDto.setId(createDepartmentDto.getCountryId());
        department.setCountry(Country.createReferenceCountry(referenceCountryDto));
        return department;
    }
    public static Department createReferenceDepartment(ReferenceDepartmentDto referenceDepartmentDto){
        final Department department = new Department();
        department.setId(referenceDepartmentDto.getId());
        return department;
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

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
