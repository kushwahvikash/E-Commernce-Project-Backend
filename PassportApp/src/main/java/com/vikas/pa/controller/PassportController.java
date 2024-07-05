package com.vikas.pa.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vikas.pa.model.Passport;
import com.vikas.pa.model.Person;
import com.vikas.pa.services.PassportService;
import com.vikas.pa.services.PersonService;

@RestController
@RequestMapping("/api")
public class PassportController {
    
    @Autowired
    private PassportService passportService;
    
    @Autowired
    private PersonService personService;
    
    // Endpoint to create a new person
    @PostMapping("/persons")
    public ResponseEntity<Person> createPerson(@RequestBody Person person) {
        return new ResponseEntity<>(personService.savePerson(person), HttpStatus.CREATED);
    }
    
    // Endpoint to create a new passport
    @PostMapping("/passports")
    public ResponseEntity<Passport> createPassport(@RequestBody Passport passport) {
        return new ResponseEntity<>(passportService.savePassport(passport), HttpStatus.CREATED);
    }
    
    // Endpoint to retrieve a person's passport details by person id
    @GetMapping("/persons/{personId}/passport")
    public ResponseEntity<Passport> getPassportByPersonId(@PathVariable Long personId) {
        Passport passport = passportService.getPassportByPerson(personId);
        if (passport != null) {
            return new ResponseEntity<>(passport, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    // Endpoint to update passport details
    @PutMapping("/passports/{passportId}")
    public ResponseEntity<Passport> updatePassport(@PathVariable Long passportId, @RequestBody Passport passportDetails) {
        Passport passport = passportService.updatePassport(passportId, passportDetails);
        if (passport != null) {
            return new ResponseEntity<>(passport, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    // Endpoint to delete a passport
    @DeleteMapping("/passports/{passportId}")
    public ResponseEntity<Void> deletePassport(@PathVariable Long passportId) {
        passportService.deletePassport(passportId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    // Other endpoints as needed
}
