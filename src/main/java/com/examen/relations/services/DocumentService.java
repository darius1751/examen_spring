package com.examen.relations.services;

import com.examen.relations.models.Document;
import com.examen.relations.repositories.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentService {

    @Autowired
    private DocumentRepository documentRepository;

    public Document create(Document document){
        return this.documentRepository.save(document);
    }
    public List<Document> createMany(List<Document> documents){
        return this.documentRepository.saveAll(documents);
    }
}
