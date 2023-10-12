package com.examen.relations.dto.person;

import jakarta.validation.constraints.Positive;

public class CreateAddressDto {

    @Positive
    private Integer type;

    @Positive
    private Integer cityId;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }
}
