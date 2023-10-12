package com.examen.relations.repositories;

import com.examen.relations.models.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Integer>, CustomRepository {}
