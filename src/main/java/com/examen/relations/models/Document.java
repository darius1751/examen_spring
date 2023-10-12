package com.examen.relations.models;

import com.examen.relations.dto.person.CreateDocumentDto;
import jakarta.persistence.*;

@Entity
@Table(indexes = {
        @Index(columnList = "type, person_id", unique = true)
})
public class Document {

    private Document(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(targetEntity = DocumentType.class)
    @JoinColumn(nullable = false, name = "type")
    private DocumentType documentType;

    @Column(nullable = false, unique = true)
    private String document;

    @ManyToOne(targetEntity = Person.class)
    @JoinColumn(nullable = false)
    private Person person;

    public static Document createDocument(Person person, CreateDocumentDto createDocumentDto){
        final Document document = new Document();
        final Integer type = createDocumentDto.getType();
        final String identification = createDocumentDto.getDocument();
        document.setPerson(person);
        document.setDocumentType(DocumentType.createDocumentType(type));
        document.setDocument(identification);
        return document;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public DocumentType getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentType documentType) {
        this.documentType = documentType;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
