package com.examen.relations.dto.person;

import jakarta.validation.constraints.Positive;

public class CreateBondingDto {

    @Positive
    private Integer id;

    @Positive
    private Integer type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
