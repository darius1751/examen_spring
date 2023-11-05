package com.examen.relations.dao;

import com.examen.relations.models.*;

import java.util.List;

public class PersonDao {

    private PersonDao(){}

    private Integer id;
    private String name;
    private List<Document> documents;
    private List<Email> emails;
    private List<Phone> phones;
    private List<Address> addresses;
    private List<Bonding> bondings;

    public static PersonDao createPersonDao(
        Integer id,
        String name,
        List<Document> documents,
        List<Email> emails,
        List<Phone> phones,
        List<Address> addresses,
        List<Bonding> bondings
    ){
        final PersonDao personDao = new PersonDao();
        personDao.setId(id);
        personDao.setName(name);
        personDao.setDocuments(documents);
        personDao.setEmails(emails);
        personDao.setPhones(phones);
        personDao.setAddresses(addresses);
        personDao.setBondings(bondings);
        return personDao;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }

    public List<Email> getEmails() {
        return emails;
    }

    public void setEmails(List<Email> emails) {
        this.emails = emails;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public List<Bonding> getBondings() {
        return bondings;
    }

    public void setBondings(List<Bonding> bondings) {
        this.bondings = bondings;
    }
}
