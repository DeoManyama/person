package com.example.person.service;

import com.example.person.entity.personDet;

import java.util.List;

public interface personService {
    personDet createPerson(personDet personDet);

    personDet getPersonById(Long personId);

    List<personDet> getAllPerson();

    personDet updatepersonDet(personDet personDet);

    void deletepersonDet(Long personDet);
}
