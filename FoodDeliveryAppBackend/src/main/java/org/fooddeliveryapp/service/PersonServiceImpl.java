package org.fooddeliveryapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.fooddeliveryapp.repositories.PersonRepository;
import org.fooddeliveryapp.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements org.fooddeliveryapp.service.PersonService {

    @Autowired
    PersonRepository personRepository;

    @Override
    public List<Person> getAll() {
        List<Person> personList = new ArrayList<>();
        personRepository.findAll().forEach(personList::add);
        return personList;
    }

    public Person save(Person p) {
        return personRepository.save(p);
    }

    @Override
    public Person findById(Long personId) {
        Optional<Person> dbPerson = personRepository.findById(personId);
        return dbPerson.orElse(null);
    }



}
