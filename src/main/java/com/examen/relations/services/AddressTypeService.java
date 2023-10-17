package com.examen.relations.services;

import com.examen.relations.models.AddressType;
import com.examen.relations.repositories.AddressTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressTypeService {

    @Autowired
    private AddressTypeRepository addressTypeRepository;


    public AddressType getReference(Integer id){
        return this.addressTypeRepository.getReferenceById(id);
    }
}
