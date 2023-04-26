package org.fooddeliveryapp.service;

import java.util.List;
import org.fooddeliveryapp.model.Person;

public interface PersonService {
    public List<Person> getAll();

    public Person save(Person p);

    public Person findById(Long personId);

}
