package com.examen.relations.services;

import com.examen.relations.models.PhoneType;
import com.examen.relations.repositories.PhoneTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhoneTypeService {

    @Autowired
    private PhoneTypeRepository phoneTypeRepository;

    public PhoneType getReference(Integer id){
        return this.phoneTypeRepository.getReferenceById(id);
    }

}
