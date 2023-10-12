package com.examen.relations.models;

import com.examen.relations.dto.city.CreateCityDto;
import com.examen.relations.dto.department.ReferenceDepartmentDto;
import jakarta.persistence.*;

@Entity
public class City {

    private City(){}
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @ManyToOne(targetEntity = Department.class)
    @JoinColumn(nullable = false)
    private Department department;

    public static City createCity(CreateCityDto createCityDto){
        City city = new City();
        city.setName(createCityDto.getName());
        ReferenceDepartmentDto referenceDepartmentDto = new ReferenceDepartmentDto();
        referenceDepartmentDto.setId(createCityDto.getDepartmentId());
        city.setDepartment(Department.createReferenceDepartment(referenceDepartmentDto));
        return city;
    }

    public static City createReferenceCity(Integer id){
        City city = new City();
        city.setId(id);
        return city;
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

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
