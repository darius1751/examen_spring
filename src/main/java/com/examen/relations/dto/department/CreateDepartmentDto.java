package com.examen.relations.dto.department;

import jakarta.validation.constraints.Positive;

public class CreateDepartmentDto {
    private String name;
    @Positive
    private Integer countryId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }
}
