package com.examen.relations.dto.person;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

public class CreatePhoneDto {

    @Positive
    private Integer type;

    @Pattern(regexp = "^3[0-2][0-3]\\d{7}$")
    private String phone;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
