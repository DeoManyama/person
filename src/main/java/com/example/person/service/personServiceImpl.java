package com.example.person.service;

import com.example.person.entity.personDet;
import com.example.person.repository.personRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class personServiceImpl implements personService {
    private personRepository personRepository;

    @Override
    public personDet createPerson(personDet personDet) {
        return personRepository.save(personDet);
    }

    @Override
    public personDet getPersonById(Long personId) {
        Optional<personDet> optionalPersonDet = personRepository.findById(personId);
        return optionalPersonDet.get();
    }


    @Override
    public List<personDet> getAllPerson() {
        return personRepository.findAll();
    }

    @Override
    public personDet updatepersonDet(personDet personDet) {
        personDet existingpersonDet = personRepository.findById(personDet.getId()).get();
        existingpersonDet.setFirstname(personDet.getFirstname());
        existingpersonDet.setFirstname(personDet.getFirstname());
        existingpersonDet.setLastname(personDet.getLastname());
        existingpersonDet.setEmail(personDet.getEmail());
        personDet updatepersonDet = personRepository.save(existingpersonDet);
        return updatepersonDet;
    }


    @Override
    public void deletepersonDet(Long personDet) {
        personRepository.deleteById(personDet);
    }
}