package com.examen.relations.repositories;

import com.examen.relations.models.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Integer>, CustomRepository {}
