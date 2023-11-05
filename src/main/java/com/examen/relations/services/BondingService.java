package com.examen.relations.services;

import com.examen.relations.exceptions.BadRequestException;
import com.examen.relations.models.Bonding;
import com.examen.relations.models.Email;
import com.examen.relations.models.Person;
import com.examen.relations.models.BondType;
import com.examen.relations.repositories.BondingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class BondingService {

    @Autowired
    private BondingRepository bondingRepository;

    @Autowired
    private  RelationService relationService;

    public Bonding create(Person binding, Person bound ,Integer relationId){
        final BondType relation = this.relationService.findOneById(relationId);
        final Bonding bonding = Bonding.createBonding(binding, bound, relation);
        return this.bondingRepository.save(bonding);
    }

    public Bonding findOneById(Integer id){
        final Optional<Bonding> bonding = this.bondingRepository.findById(id);
        if(bonding.isEmpty())
            throw new BadRequestException("Not exist bonding with id: " + id);
        return bonding.get();
    }

    public List<Bonding> findAllByPerson(Person person){
        Example<Bonding> bondingExample = Example.of(Bonding.probeBonding(person));
        return this.bondingRepository.findAll(bondingExample);
    }

    public List<Bonding> createMany(List<Bonding> bondings){
        return this.bondingRepository.saveAll(bondings);
    }


    public Bonding deleteOneById(Integer id){
        Bonding bonding = this.findOneById(id);
        this.bondingRepository.deleteById(id);
        return bonding;
    }
}
