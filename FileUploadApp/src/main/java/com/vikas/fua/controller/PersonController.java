package com.vikas.fua.controller;
import java.util.List;
import java.util.Optional;

/*
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.web.bind.annotation.*;
 * 
 * import java.util.Optional;
 * 
 * @RestController
 * 
 * @RequestMapping("/persons") public class PersonController {
 * 
 * @Autowired private PersonRepository personRepository;
 * 
 * @GetMapping("/{id}") public Optional<Person> getPersonById(@PathVariable Long
 * id) { return personRepository.findById(id); }
 * 
 * @PostMapping("/") public Person createPerson(@RequestBody Person person) {
 * return personRepository.save(person); }
 * 
 * @PutMapping("/{id}") public Person updatePerson(@PathVariable Long
 * id, @RequestBody Person updatedPerson) { return personRepository.findById(id)
 * .map(person -> { person.setName(updatedPerson.getName());
 * person.setGender(updatedPerson.getGender());
 * person.setDateOfBirth(updatedPerson.getDateOfBirth());
 * person.setPhoto(updatedPerson.getPhoto());
 * person.setResume(updatedPerson.getResume()); return
 * personRepository.save(person); }) .orElseThrow(() -> new
 * ResourceNotFoundException("Person not found with id " + id)); }
 * 
 * @DeleteMapping("/{id}") public void deletePerson(@PathVariable Long id) {
 * personRepository.deleteById(id); } }
 */
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

import com.vikas.fua.model.Person;
import com.vikas.fua.services.PersonService;

@RestController
@RequestMapping("/persons")
public class PersonController {

	@Autowired
    private PersonService personService;

   

    @GetMapping
    public List<Person> getAllPersons() {
        return personService.getAllPersons();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable Long id) {
        Optional<Person> person = personService.getPersonById(id);
        return person.map(value -> ResponseEntity.ok().body(value))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Person> createPerson(@RequestBody Person person) {
        Person createdPerson = personService.createPerson(person);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPerson);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable Long id, @RequestBody Person person) {
        Person updatedPerson = personService.updatePerson(id, person);
        return ResponseEntity.ok().body(updatedPerson);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable Long id) {
        personService.deletePerson(id);
        return ResponseEntity.noContent().build();
    }
}
