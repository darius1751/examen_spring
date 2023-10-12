package com.examen.relations.repositories;

import com.examen.relations.models.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository extends JpaRepository<Document, Integer> {}
