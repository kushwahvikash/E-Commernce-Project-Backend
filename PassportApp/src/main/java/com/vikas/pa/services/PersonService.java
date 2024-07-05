package com.vikas.pa.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vikas.pa.model.Person;
import com.vikas.pa.repository.PersonRepository;

@Service
public class PersonService {
    
    @Autowired
    private PersonRepository personRepository;
    
    public Person savePerson(Person person) {
        return personRepository.save(person);
    }
    
    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }
    
    public Person getPersonById(Long personId) {
        return personRepository.findById(personId)
                .orElse(null);
    }
    
    public void deletePerson(Long personId) {
        personRepository.deleteById(personId);
    }
    
    // Other operations as needed
}
