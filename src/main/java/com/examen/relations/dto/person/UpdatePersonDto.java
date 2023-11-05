package com.examen.relations.dto.person;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Pattern;

import java.util.List;

public class UpdatePersonDto {

    @Pattern(regexp = "^[A-Za-z\s]{3,}$")
    @Null
    private String name;

    @Valid
    @Null
    private List<CreateDocumentDto> documents;

    @Valid
    @Null
    private List<CreateEmailDto> emails;

    @Valid
    @Null
    private List<CreatePhoneDto> phones;

    @Valid
    @Null
    private List<CreateAddressDto> addresses;

    @Valid
    @Null
    private List<CreateBondingDto> bondings;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CreateDocumentDto> getDocuments() {
        return documents;
    }

    public void setDocuments(List<CreateDocumentDto> documents) {
        this.documents = documents;
    }

    public List<CreateEmailDto> getEmails() {
        return emails;
    }

    public void setEmails(List<CreateEmailDto> emails) {
        this.emails = emails;
    }

    public List<CreatePhoneDto> getPhones() {
        return phones;
    }

    public void setPhones(List<CreatePhoneDto> phones) {
        this.phones = phones;
    }

    public List<CreateAddressDto> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<CreateAddressDto> addresses) {
        this.addresses = addresses;
    }

    public List<CreateBondingDto> getBondings() {
        return bondings;
    }

    public void setBondings(List<CreateBondingDto> bondings) {
        this.bondings = bondings;
    }
}
