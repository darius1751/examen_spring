package com.examen.relations.repositories;

import com.examen.relations.models.Email;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepository extends JpaRepository<Email, Integer> {}
