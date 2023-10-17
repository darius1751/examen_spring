package com.examen.relations.services;

import com.examen.relations.models.EmailType;
import com.examen.relations.repositories.EmailTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailTypeService {

    @Autowired
    private EmailTypeRepository emailTypeRepository;

    public EmailType getReference(Integer id){
        return this.emailTypeRepository.getReferenceById(id);
    }
}
