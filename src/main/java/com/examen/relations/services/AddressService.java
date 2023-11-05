package com.examen.relations.services;

import com.examen.relations.exceptions.BadRequestException;
import com.examen.relations.models.Address;
import com.examen.relations.models.Email;
import com.examen.relations.models.Person;
import com.examen.relations.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    //3 - 4
    // Controladores ->
    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private AddressTypeService addressTypeService;
    @Autowired
    private CityService cityService;

    public Address create(Address address){
        return this.addressRepository.save(address);
    }

    public Address findOneById(Integer id){
        final Optional<Address> address = this.addressRepository.findById(id);
        if(address.isEmpty())
            throw new BadRequestException("Not exist address with id: " + id);
        return address.get();
    }

    public List<Address> findAllByPerson(Person person){
        Example<Address> addressExample = Example.of(Address.probeAddress(person));
        return this.addressRepository.findAll(addressExample);
    }

    public List<Address> createMany(List<Address> addresses){
        return this.addressRepository.saveAll(addresses);
    }

    public Address deleteOneById(Integer id){
        final Address address = this.findOneById(id);
        this.addressRepository.deleteById(id);
        return address;
    }
}
