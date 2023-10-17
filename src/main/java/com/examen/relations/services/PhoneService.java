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

    @Autowired
    private PhoneTypeService phoneTypeService;

    public Phone create(Phone phone){
        return this.phoneRepository.save(phone);
    }

    public List<Phone> createMany(List<Phone> phones){
        phones = phones.stream().peek(
                phone -> {
                    phone.setType(phoneTypeService.getReference(phone.getId()));
                }
        ).toList();
        return this.phoneRepository.saveAll(phones);
    }
}
