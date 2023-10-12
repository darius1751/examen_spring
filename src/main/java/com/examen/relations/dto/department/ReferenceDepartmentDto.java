package com.examen.relations.dto.department;

import jakarta.validation.constraints.Positive;

public class ReferenceDepartmentDto {

    @Positive
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
