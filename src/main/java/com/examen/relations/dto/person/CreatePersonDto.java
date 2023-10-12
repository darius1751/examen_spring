package com.examen.relations.dto.person;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

import java.util.List;

public class CreatePersonDto {

    @NotBlank
    @NotEmpty
    @Pattern(regexp = "^[A-Za-z\s]{3,}$")
    private String name;

    @Valid
    @NotEmpty
    private List<CreateDocumentDto> documents;

    @Valid
    @NotEmpty
    private List<CreateEmailDto> emails;

    @Valid
    @NotEmpty
    private List<CreatePhoneDto> phones;

    @Valid
    @NotEmpty
    private List<CreateAddressDto> addresses;

    @Valid
    @NotEmpty
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
