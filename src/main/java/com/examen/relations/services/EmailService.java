package com.examen.relations.services;

import com.examen.relations.models.Email;
import com.examen.relations.repositories.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailService {

    @Autowired
    private EmailRepository emailRepository;

    public Email create(Email email){
        return this.emailRepository.save(email);
    }

    public List<Email> createMany(List<Email> emails){
        return this.emailRepository.saveAll(emails);
    }
}
