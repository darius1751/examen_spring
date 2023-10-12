package com.examen.relations.dto.city;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

public class CreateCityDto {
    @NotBlank
    @NotEmpty
    @Pattern(regexp = "^[A-Za-z\s]{3,}$")
    private String name;

    @Positive
    private Integer departmentId;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }
}
