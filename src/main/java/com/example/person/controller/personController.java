package com.example.person.controller;

import com.example.person.entity.personDet;
import com.example.person.service.personService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/personal")
public class personController {
    private personService personService;

    @PostMapping
    public ResponseEntity<personDet> createperson(@RequestBody personDet personDet){
        personDet savedperson = personService.createPerson(personDet);
        return new ResponseEntity<>(savedperson, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<personDet>> getAllperson(){
        List<personDet> personDets = personService.getAllPerson();
        return new ResponseEntity<>(personDets, HttpStatus.OK);
    }
    //Build Update personDet REST API

    @PutMapping("{id}")
    //http://localhost:8080/api/personDet/1
    public ResponseEntity<personDet> updatepersonDet(@PathVariable("id") Long personDetId, @RequestBody personDet personDet){
        personDet.setId(personDetId);
        personDet updateperson = personService.updatepersonDet(personDet);
        return new ResponseEntity<>(updateperson, HttpStatus.OK);
    }
    //Build Delete personDet REST API

    @DeleteMapping("{id}")
    public ResponseEntity<String> deletepersonDet(@PathVariable("id") Long personDetId){
       personService.deletepersonDet(personDetId);
       return new ResponseEntity<>("personDet successfully deleted!", HttpStatus.OK);

    }
}
