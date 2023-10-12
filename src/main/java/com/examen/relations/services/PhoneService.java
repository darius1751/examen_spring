package com.examen.relations.services;

import com.examen.relations.models.Phone;
import com.examen.relations.repositories.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhoneService {

    @Autowired
    private PhoneRepository phoneRepository;

    public Phone create(Phone phone){
        return this.phoneRepository.save(phone);
    }

    public List<Phone> createMany(List<Phone> phones){
        return this.phoneRepository.saveAll(phones);
    }
}
