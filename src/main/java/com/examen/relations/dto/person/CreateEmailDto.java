package com.examen.relations.dto.person;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Positive;

public class CreateEmailDto {

    @Positive
    private Integer type;

    @Email
    private String email;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
