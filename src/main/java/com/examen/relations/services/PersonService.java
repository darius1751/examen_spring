package com.examen.relations.services;

import com.examen.relations.dao.PersonDao;
import com.examen.relations.dto.person.*;
import com.examen.relations.exceptions.BadRequestException;
import com.examen.relations.models.*;
import com.examen.relations.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private DocumentService documentService;

    @Autowired
    private EmailService emailService;

    @Autowired
    private PhoneService phoneService;

    @Autowired
    private AddressService addressService;

    @Autowired
    private BondingService bondingService;


    public List<Person> findAll(){
        return this.personRepository.findAll();
    }

    public Person findOneById(Integer id){
        Optional<Person> person =  this.personRepository.findById(id);
        if(person.isEmpty())
            throw new BadRequestException("Not exist person with id: " + id);
        return person.get();
    }

    public PersonDao create(CreatePersonDto createPersonDto){
        final Person person = this.personRepository.save(Person.createPerson(createPersonDto));
        final List<CreateDocumentDto> createDocumentsDto = createPersonDto.getDocuments();
        final List<CreateEmailDto> createEmailsDto = createPersonDto.getEmails();
        final List<CreatePhoneDto> createPhonesDto = createPersonDto.getPhones();
        final List<CreateBondingDto> createBondingsDto = createPersonDto.getBondings();
        final List<CreateAddressDto> createAddressesDto = createPersonDto.getAddresses();
        List<Document> documents = createDocumentsDto.stream().map(document -> Document.createDocument(person,document)).toList();
        List<Email> emails = createEmailsDto.stream().map(email -> Email.createEmail(person,email)).toList();
        List<Phone> phones = createPhonesDto.stream().map(phone -> Phone.createPhone(person,phone)).toList();
        List<Address> addresses = createAddressesDto.stream().map(address-> Address.createAddress(person, address)).toList();
        if(createBondingsDto != null) {
            List<Bonding> bondings = createBondingsDto.stream().map(bonding -> bondingService.create(person, this.findOneById(bonding.getId()), bonding.getType())).toList();
        }

        documents = this.documentService.createMany(documents);
        emails = this.emailService.createMany(emails);
        phones = this.phoneService.createMany(phones);
        addresses = this.addressService.createMany(addresses);

        return PersonDao.createPersonDao(
                person.getId(),
                person.getName(),
                documents,
                emails,
                phones,
                addresses
        );
    }
}
