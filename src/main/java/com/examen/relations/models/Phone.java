package com.examen.relations.models;

import com.examen.relations.dto.person.CreatePhoneDto;
import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(
        indexes = {
                @Index(columnList = "type, person_id", unique = true)
        }
)
public class Phone {

    private Phone(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(targetEntity = PhoneType.class)
    @JoinColumn(name = "type", nullable = false)
    private PhoneType type;

    @Column(nullable = false, unique = true)
    private String phone;

    @Column(nullable = false)
    @ColumnDefault(value = "true")
    private Boolean state;

    @ManyToOne(targetEntity = Person.class)
    @JoinColumn(nullable = false)
    private Person person;

    public static Phone createPhone(Person person, CreatePhoneDto createPhoneDto){
        Phone phone = new Phone();
        phone.setPhone(createPhoneDto.getPhone());
        phone.setType(PhoneType.createPhoneType(createPhoneDto.getType()));
        phone.setPerson(person);
        phone.setState(true);
        return phone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PhoneType getType() {
        return type;
    }

    public void setType(PhoneType type) {
        this.type = type;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
