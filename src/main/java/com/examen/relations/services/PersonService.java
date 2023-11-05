package com.examen.relations.services;

import com.examen.relations.dao.PersonDao;
import com.examen.relations.dto.person.*;
import com.examen.relations.exceptions.BadRequestException;
import com.examen.relations.models.*;
import com.examen.relations.repositories.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private Logger logger;
    PersonService(){
        this.logger = LoggerFactory.getLogger(PersonService.class);
    }
    public List<Person> findAll(){
        return this.personRepository.findAll();
    }

    public Person getOneById(Integer id){
        Optional<Person> person =  this.personRepository.findById(id);
        if(person.isEmpty())
            throw new BadRequestException("Not exist person with id: " + id);
        return person.get();
    }

    public PersonDao findOneById(Integer id) {
        Person person = this.getOneById(id);
        return PersonDao.createPersonDao(
                id,
                person.getName(),
                documentService.findAllByPerson(person),
                emailService.findAllByPerson(person),
                phoneService.findAllByPerson(person),
                addressService.findAllByPerson(person),
                bondingService.findAllByPerson(person)
        );
    }
    public PersonDao create(CreatePersonDto createPersonDto){
        final Person person = this.personRepository.save(Person.createPerson(createPersonDto));
        final List<CreateDocumentDto> createDocumentsDto = createPersonDto.getDocuments();
        final List<CreateEmailDto> createEmailsDto = createPersonDto.getEmails();
        final List<CreatePhoneDto> createPhonesDto = createPersonDto.getPhones();
        final List<CreateBondingDto> createBondingsDto = createPersonDto.getBondings();
        final List<CreateAddressDto> createAddressesDto = createPersonDto.getAddresses();
        List<Bonding> bondings = null;
        List<Document> documents = createDocumentsDto.stream().map(document -> Document.createDocument(person,document)).toList();
        List<Email> emails = createEmailsDto.stream().map(email -> Email.createEmail(person,email)).toList();
        List<Phone> phones = createPhonesDto.stream().map(phone -> Phone.createPhone(person,phone)).toList();
        List<Address> addresses = createAddressesDto.stream().map(address-> Address.createAddress(person, address)).toList();
        if(createBondingsDto != null) {
            bondings = createBondingsDto.stream().map(bonding -> bondingService.create(person, this.getOneById(bonding.getId()), bonding.getType())).toList();
        }

        documents = this.documentService.createMany(documents);
        emails = this.emailService.createMany(emails);
        phones = this.phoneService.createMany(phones);
        addresses = this.addressService.createMany(addresses);
        if(bondings != null)
            bondings = this.bondingService.createMany(bondings);
        return PersonDao.createPersonDao(
                person.getId(),
                person.getName(),
                documents,
                emails,
                phones,
                addresses,
                bondings
        );
    }

    public PersonDao updateOneById(Integer id, UpdatePersonDto updatePersonDto){
        Person person = this.getOneById(id);
        person.setName(updatePersonDto.getName());
        this.personRepository.save(person);
        final List<CreateDocumentDto> documents = updatePersonDto.getDocuments();
        final List<CreateEmailDto> emails = updatePersonDto.getEmails();
        final List<CreatePhoneDto> phones = updatePersonDto.getPhones();
        final List<CreateAddressDto> addresses = updatePersonDto.getAddresses();
        final List<CreateBondingDto> bondings = updatePersonDto.getBondings();
        List<Document> documentsDao = null;
        List<Email> emailsDao = null;
        List<Phone> phonesDao = null;
        List<Address> addressDao = null;
        List<Bonding> bondingsDao = null;
        if(!documents.isEmpty()){
            documentsDao = documentService.update(documents.stream().map(
                    (createDocumentDto)-> Document.updateDocument(person, createDocumentDto)
            ).toList()
            );
        }
        if(!emails.isEmpty()){
            emailsDao = this.emailService.createMany(emails.stream().map(
                            (email)-> Email.createEmail(person, email)
                    ).toList()
            );
        }
        if(!phones.isEmpty()){
            phonesDao = this.phoneService.createMany(phones.stream().map(
                            (phone)-> Phone.createPhone(person, phone)
                    ).toList()
            );
        }
        if(!addresses.isEmpty()){
            addressDao = this.addressService.createMany(addresses.stream().map(
                            (address)-> Address.createAddress(person, address)
                    ).toList()
            );
        }
        if(!bondings.isEmpty()){
            bondingsDao = this.bondingService.createMany(bondings.stream().map(
                            (bonding)-> Bonding.createBonding(person, Person.createBond(bonding.getId()), BondType.createBondType(bonding.getId()))
                    ).toList()
            );
        }
        return PersonDao.createPersonDao(
                id,
                person.getName(),
                documentsDao,
                emailsDao,
                phonesDao,
                addressDao,
                bondingsDao
        );
    }

    public PersonDao deleteOneById(Integer id){
        Person person = this.getOneById(id);
        List<Document> documents = this.documentService.findAllByPerson(person);
        List<Email> emails = this.emailService.findAllByPerson(person);
        List<Phone> phones = this.phoneService.findAllByPerson(person);
        List<Address> addresses = this.addressService.findAllByPerson(person);
        List<Bonding> bondings = this.bondingService.findAllByPerson(person);
        documents.forEach((document)-> this.documentService.deleteOneById(document.getId()));
        emails.forEach((email -> this.emailService.deleteOneById(email.getId())));
        phones.forEach((phone -> this.phoneService.deleteOneById(phone.getId())));
        addresses.forEach((address -> this.addressService.deleteOneById(address.getId())));
        bondings.forEach(bonding -> this.bondingService.deleteOneById(bonding.getId()));
        this.personRepository.deleteById(id);
        return PersonDao.createPersonDao(
                id,
                person.getName(),
                documents,
                emails,
                phones,
                addresses,
                bondings

        );
    }
    
}
