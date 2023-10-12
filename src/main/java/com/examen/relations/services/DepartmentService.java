package com.examen.relations.services;

import com.examen.relations.exceptions.BadRequestException;
import com.examen.relations.models.Department;
import com.examen.relations.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private CountryService countryService;

    public List<Department> findAll(){
        return this.departmentRepository.findAll();
    }

    public Department findOneById(Integer id){
        final Optional<Department> department = this.departmentRepository.findById(id);
        if(department.isEmpty())
            throw new BadRequestException("Not exist department with id: " + id);
        return department.get();
    }

    public Department create(Department department){
        final String name = department.getName();
        Integer countryId = department.getCountry().getId();
        this.countryService.getOneById(countryId);
        final boolean exist = this.departmentRepository.existsByName(name);
        if(exist)
            throw new BadRequestException("Exist department with name: " + name);
        department.setCountry(this.countryService.getReference(countryId));
        return this.departmentRepository.save(department);
    }

    public Department delete(Integer id){
        final Department department = this.findOneById(id);
        this.departmentRepository.deleteById(id);
        return department;
    }

    public Department getReference(Integer id){
        return this.departmentRepository.getReferenceById(id);
    }
}
