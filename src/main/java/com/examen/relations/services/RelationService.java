package com.examen.relations.services;

import com.examen.relations.exceptions.BadRequestException;
import com.examen.relations.models.BondType;
import com.examen.relations.repositories.RelationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RelationService {

    @Autowired
    private RelationRepository relationRepository;

    public BondType findOneById(Integer id){
        Optional<BondType> relation = this.relationRepository.findById(id);
        if(relation.isEmpty())
            throw new BadRequestException("Not exist relation with id: " + id);
        else
            return relation.get();
    }
}
