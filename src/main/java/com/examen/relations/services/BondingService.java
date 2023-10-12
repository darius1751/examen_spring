package com.examen.relations.services;

import com.examen.relations.models.Bonding;
import com.examen.relations.models.Person;
import com.examen.relations.models.BondType;
import com.examen.relations.repositories.BondingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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
}
