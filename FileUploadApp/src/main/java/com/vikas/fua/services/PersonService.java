package com.vikas.fua.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vikas.fua.model.Person;
import com.vikas.fua.repository.PersonRepository;

@Service
public class PersonService {

	@Autowired
	private PersonRepository personRepository;

	public List<Person> getAllPersons() {
		return (List<Person>) personRepository.findAll();
	}

	public Optional<Person> getPersonById(Long id) {
		return personRepository.findById(id);
	}

	public Person createPerson(Person person) {
		return personRepository.save(person);
	}

	public Person updatePerson(Long id, Person updatedPerson) {
		if (personRepository.existsById(id)) {
			updatedPerson.setPersonId(id);
			return personRepository.save(updatedPerson);
		} else {
			throw new RuntimeException("Person not found with id: " + id);
		}
	}

	public void deletePerson(Long id) {
		if (personRepository.existsById(id)) {
			personRepository.deleteById(id);
		} else {
			throw new RuntimeException("Person not found with id: " + id);
		}
	}
}
