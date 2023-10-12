package com.examen.relations.models;

import jakarta.persistence.*;

@Entity
public class EmailType {

    private EmailType(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String type;


    public static EmailType createEmailType(Integer id){
        final EmailType emailType = new EmailType();
        emailType.setId(id);
        return emailType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
