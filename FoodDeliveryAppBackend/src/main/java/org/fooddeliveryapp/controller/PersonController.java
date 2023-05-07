package org.fooddeliveryapp.controller;

import java.util.List;

import org.fooddeliveryapp.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.fooddeliveryapp.service.PersonService;

@RestController
public class PersonController {

    @Autowired
    PersonService personService;

    @PostMapping(path = "/api/person")
    public ResponseEntity register(@RequestBody Person p) {
        // TODO: remove this from Controller after changing to ENUM, and return of this to ResponseEntity<Person>
        // https://medium.com/javarevisited/an-effective-way-to-use-java-enums-in-your-spring-application-485c969794a8 (check!)
        if (!p.getPersonType().equals("DeliveryMan") && !p.getPersonType().equals("Customer")) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid Person type, must be either Customer or DeliveryMan");
        }
        return ResponseEntity.ok(personService.save(p));
    }

    @GetMapping(path = "/api/person")
    public ResponseEntity<List<Person>> getAllPersons() {
        return ResponseEntity.ok(personService.getAll());
    }

    @GetMapping(path = "/api/person/{pers-id}")
    public ResponseEntity<Person> getPersonById(@PathVariable(name="person-id", required=true)Long personId) {
        Person person = personService.findById(personId);
        if (person != null) {
            return ResponseEntity.ok(person);
        }
        return ResponseEntity.notFound().build();
    }

}
