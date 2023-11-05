package com.examen.relations.services;

import com.examen.relations.exceptions.BadRequestException;
import com.examen.relations.models.Email;
import com.examen.relations.models.Person;
import com.examen.relations.models.Phone;
import com.examen.relations.repositories.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PhoneService {

    @Autowired
    private PhoneRepository phoneRepository;

    @Autowired
    private PhoneTypeService phoneTypeService;

    public Phone create(Phone phone){
        return this.phoneRepository.save(phone);
    }

    public Phone findOneById(Integer id){
        final Optional<Phone> phone = this.phoneRepository.findById(id);
        if(phone.isEmpty())
            throw new BadRequestException("Not exist phone with id: " + id);
        return phone.get();
    }

    public List<Phone> findAllByPerson(Person person){
        Example<Phone> phoneExample = Example.of(Phone.probePhone(person));
        return this.phoneRepository.findAll(phoneExample);
    }
    public List<Phone> createMany(List<Phone> phones){
        return this.phoneRepository.saveAll(phones);
    }

    public Phone deleteOneById(Integer id){
        final Phone phone = this.findOneById(id);
        this.phoneRepository.deleteById(id);
        return phone;
    }
}
