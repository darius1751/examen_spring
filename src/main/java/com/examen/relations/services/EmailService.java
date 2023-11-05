package com.examen.relations.services;

import com.examen.relations.exceptions.BadRequestException;
import com.examen.relations.models.Document;
import com.examen.relations.models.Email;
import com.examen.relations.models.Person;
import com.examen.relations.repositories.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmailService {

    @Autowired
    private EmailRepository emailRepository;

    @Autowired
    private EmailTypeService emailTypeService;

    public Email create(Email email){
        return this.emailRepository.save(email);
    }

    public Email findOneById(Integer id){
        final Optional<Email> email = this.emailRepository.findById(id);
        if(email.isEmpty())
            throw new BadRequestException("Not exist email with id: " + id);
        return email.get();
    }
    public List<Email> createMany(List<Email> emails){
        return this.emailRepository.saveAll(emails);
    }

    public List<Email> findAllByPerson(Person person){
        Example<Email> documentExample = Example.of(Email.probeEmail(person));
        return this.emailRepository.findAll(documentExample);
    }
    public Email deleteOneById(Integer id){
        final Email email = this.findOneById(id);
        this.emailRepository.deleteById(id);
        return email;
    }
}

