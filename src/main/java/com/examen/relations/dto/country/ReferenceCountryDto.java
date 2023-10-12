package com.examen.relations.dto.country;

import jakarta.validation.constraints.Positive;

public class ReferenceCountryDto {

    @Positive
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
