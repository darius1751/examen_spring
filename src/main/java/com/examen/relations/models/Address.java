package com.examen.relations.models;

import com.examen.relations.dto.person.CreateAddressDto;
import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(
        indexes = {
                @Index(columnList = "type, person_id", unique = true)
        }
)
public class Address {

    private Address(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(targetEntity = AddressType.class)
    @JoinColumn(nullable = false, name = "type")
    private AddressType type;

    @ManyToOne(targetEntity = City.class)
    private City city;

    @Column
    @ColumnDefault(value = "true")
    private Boolean state;

    @ManyToOne(targetEntity = Person.class)
    private Person person;

    public static Address createAddress(Person person,CreateAddressDto createAddressDto){
        final Address address = new Address();
        address.setCity(City.createReferenceCity(createAddressDto.getCityId()));
        address.setType(AddressType.createAddressType(createAddressDto.getType()));
        address.setPerson(person);
        address.setState(true);
        return address;
    }

    public static Address probeAddress(Person person){
        final Address address = new Address();
        address.setPerson(person);
        return address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public AddressType getType() {
        return type;
    }

    public void setType(AddressType type) {
        this.type = type;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
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
