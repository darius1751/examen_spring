package com.examen.relations.repositories;

import com.examen.relations.models.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Integer>, CustomRepository{}
