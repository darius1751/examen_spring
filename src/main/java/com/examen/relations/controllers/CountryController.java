package com.examen.relations.controllers;

import com.examen.relations.dto.country.CreateCountryDto;
import com.examen.relations.dto.country.UpdateCountryDto;
import com.examen.relations.models.Country;
import com.examen.relations.services.CountryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/country")
public class CountryController {

    private Logger logger = LoggerFactory.getLogger(CountryController.class);

    @Autowired
    private CountryService countryService;

    @GetMapping()
    public @ResponseBody List<Country> getAll(){
        return this.countryService.getAll();
    }

    @GetMapping("{id}")
    public @ResponseBody Country getOneById(
            @PathVariable Integer id
    ){
        return this.countryService.getOneById(id);
    }

    @PostMapping()
    public @ResponseBody Country create(
            @RequestBody() CreateCountryDto createCountryDto
    ){
        return this.countryService.create(Country.createCountry(createCountryDto));
    }

    @PatchMapping("{id}")
    public @ResponseBody Country update(
            @PathVariable("id") Integer id,
            @RequestBody() UpdateCountryDto updateCountryDto
    ){
        return this.countryService.updateOneById(Country.updateCountry(id, updateCountryDto));
    }

    @DeleteMapping("{id}")
    public @ResponseBody Country delete(
        @PathVariable("id") Integer id
    ){
        return this.countryService.deleteOneById(id);
    }
}
