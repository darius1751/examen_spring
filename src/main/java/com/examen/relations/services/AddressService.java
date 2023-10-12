package com.examen.relations.services;

import com.examen.relations.models.Address;
import com.examen.relations.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private CityService cityService;

    public Address create(Address address){
        return this.addressRepository.save(address);
    }
    public List<Address> createMany(List<Address> addresses){
         addresses = addresses.stream().peek(address -> address.setCity(cityService.getReference(address.getId()))).toList();
        return this.addressRepository.saveAll(addresses);
    }

}