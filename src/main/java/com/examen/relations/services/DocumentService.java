package com.examen.relations.services;

import com.examen.relations.exceptions.BadRequestException;
import com.examen.relations.models.Document;
import com.examen.relations.models.Person;
import com.examen.relations.repositories.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.List;
import java.util.Optional;

@Service
public class DocumentService {

    @Autowired
    private DocumentRepository documentRepository;

    public Document create(Document document){
        return this.documentRepository.save(document);
    }
    private Document findOneById(Integer id){
        final Optional<Document> document = this.documentRepository.findById(id);
        if(document.isEmpty())
            throw new BadRequestException("Not exist document with id: " + id);
        return document.get();
    }

    public List<Document> findAllByPerson(Person person){
        Example<Document> documentExample = Example.of(Document.probeDocument(person));
        return this.documentRepository.findAll(documentExample);
    }

    public List<Document> createMany(List<Document> documents){
        return this.documentRepository.saveAll(documents);
    }

    public List<Document> update(List<Document> documents){
        return this.documentRepository.saveAll(documents);
    }
    public Document deleteOneById(Integer id){
        Document document = this.findOneById(id);
        this.documentRepository.deleteById(id);
        return document;
    }
}
