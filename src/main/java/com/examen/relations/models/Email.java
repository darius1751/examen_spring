package com.examen.relations.models;

import com.examen.relations.dto.person.CreateEmailDto;
import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(
        indexes = {
                @Index(columnList = "type, person_id",unique = true)
        }
)
public class Email {

    private Email(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(targetEntity = EmailType.class)
    @JoinColumn(name = "type")
    private EmailType emailType;


    @Column(unique = true, nullable = false)
    private String email;

    @ManyToOne(targetEntity = Person.class)
    private Person person;

    @Column(nullable = false)
    @ColumnDefault(value = "true")
    private Boolean state;

    public static Email createEmail(Person person, CreateEmailDto createEmailDto){
        final Email email = new Email();
        email.setEmail(createEmailDto.getEmail());
        email.setPerson(person);
        email.setEmailType(EmailType.createEmailType(createEmailDto.getType()));
        email.setState(true);
        return email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public EmailType getEmailType() {
        return emailType;
    }

    public void setEmailType(EmailType emailType) {
        this.emailType = emailType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }
}
