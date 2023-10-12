package com.examen.relations.controllers;

import com.examen.relations.dto.city.CreateCityDto;
import com.examen.relations.models.City;
import com.examen.relations.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/city")
public class CityController {

    @Autowired
    private CityService cityService;

    @PostMapping
    private @ResponseBody City create(
            @RequestBody CreateCityDto createCityDto
    ){
        return this.cityService.create(City.createCity(createCityDto));
    }

    @GetMapping
    private @ResponseBody List<City> findAll(){
        return this.cityService.findAll();
    }

    @GetMapping("{id}")
    private @ResponseBody City findOneById(
            @PathVariable("id") Integer id
    ){
        return this.cityService.findOneById(id);
    }

    @DeleteMapping("{id}")
    private @ResponseBody City deleteOneById(
            @PathVariable("id") Integer id
    ){
        return this.cityService.deleteOneById(id);
    }
}
