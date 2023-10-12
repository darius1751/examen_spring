package com.examen.relations.dto.country;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

public class UpdateCountryDto {

    @NotBlank
    @NotEmpty
    @Pattern(regexp = "^[A-Za-z\s]{3,}$")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
