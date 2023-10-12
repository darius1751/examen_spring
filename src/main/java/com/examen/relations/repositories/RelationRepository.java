package com.examen.relations.repositories;

import com.examen.relations.models.BondType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RelationRepository extends JpaRepository<BondType, Integer> {}
