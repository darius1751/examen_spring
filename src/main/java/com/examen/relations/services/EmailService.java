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

    @Autowired
    private EmailTypeService emailTypeService;

    public Email create(Email email){
        return this.emailRepository.save(email);
    }

    public List<Email> createMany(List<Email> emails){
        emails = emails.stream().peek(email -> email.setEmailType(emailTypeService.getReference(email.getEmailType().getId()))).toList();
        return this.emailRepository.saveAll(emails);

    }
}
