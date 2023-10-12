package com.examen.relations.controllers;

import com.examen.relations.Dao.PersonDao;
import com.examen.relations.dto.person.CreatePersonDto;
import com.examen.relations.models.Person;
import com.examen.relations.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping
    private @ResponseBody PersonDao create(
            @RequestBody CreatePersonDto createPersonDto
    ){
        return this.personService.create(createPersonDto);
    }

    @GetMapping()
    private @ResponseBody List<Person> findAll(){
        return this.personService.findAll();
    }

    @GetMapping("{id}")
    private @ResponseBody Person findOneById(
            @PathVariable("id") Integer id
    ){
        return this.personService.findOneById(id);
    }
}
