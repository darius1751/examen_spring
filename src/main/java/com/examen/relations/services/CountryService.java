package com.examen.relations.services;

import com.examen.relations.exceptions.BadRequestException;
import com.examen.relations.models.Country;
import com.examen.relations.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    public List<Country> getAll(){
        return this.countryRepository.findAll();
    }
    public Country getOneById(Integer id){
        Optional<Country> country = this.countryRepository.findById(id);
        if(country.isEmpty())
            throw new BadRequestException("Not exist country with id: " + id);
        return country.get();
    }

    public Country create(Country country){
        final String name = country.getName();
        final boolean exist = this.countryRepository.existsByName(name);
        if(exist)
            throw new BadRequestException("Error in create Country, exist country with name: " + name);
        return this.countryRepository.save(country);
    }



    public Country updateOneById(Country country){
        this.getOneById(country.getId());
        final String name = country.getName();
        if(this.countryRepository.existsByName(name))
            throw new BadRequestException("Error in update One country, exist country with name: " + name );
        return this.countryRepository.save(country);
    }

    public Country deleteOneById(Integer id){
        final Country deletedCountry = getOneById(id);
        this.countryRepository.deleteById(id);
        return deletedCountry;
    }

    public Country getReference(Integer id){
        return this.countryRepository.getReferenceById(id);
    }
}
