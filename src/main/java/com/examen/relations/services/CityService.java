package com.examen.relations.services;

import com.examen.relations.exceptions.BadRequestException;
import com.examen.relations.models.City;
import com.examen.relations.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private DepartmentService departmentService;

    public List<City> findAll(){
        return this.cityRepository.findAll();
    }

    public City findOneById(Integer id){
        final Optional<City> city = this.cityRepository.findById(id);
        if(city.isEmpty())
            throw new BadRequestException("Not exist city with id: " + id);
        return city.get();
    }

    public City create(City city){
        final String name = city.getName();
        Integer departmentId = city.getDepartment().getId();
        this.departmentService.findOneById(departmentId);
        final boolean exist = this.cityRepository.existsByName(name);
        if(exist)
            throw new BadRequestException("Exist city with name: " + name);
        city.setDepartment(departmentService.getReference(departmentId));
        return this.cityRepository.save(city);
    }

    public City deleteOneById(Integer id){
        City city = this.findOneById(id);
        this.cityRepository.delete(city);
        return city;
    }

    public City getReference(Integer id){
        return this.cityRepository.getReferenceById(id);
    }
}
