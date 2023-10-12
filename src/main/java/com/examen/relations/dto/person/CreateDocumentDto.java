package com.examen.relations.dto.person;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

public class CreateDocumentDto {

    @Positive
    private Integer type;

    @Pattern(regexp = "^\\d{8,10}$")
    private String document;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }
}
