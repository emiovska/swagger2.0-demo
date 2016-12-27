package com.demo.rest;

import com.demo.model.Person;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by elena.miovska on 26.12.2016 г..
 */
@RestController
@RequestMapping("/person")
public class PersonResource {

    @RequestMapping(value = "/save", method = RequestMethod.POST, consumes = "application/json")
    public String savePerson(Person person) {
        return "Saving person with id " + person.getId();
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public Person getPersonById(@PathVariable Long id) {
        return new Person();
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public void updatePerson(Person person) {
        System.out.print("Updating person with id " + person.getId());
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void deletePerson(@PathVariable Long id) {
        System.out.print("Deleting person with id " + id);
    }
}
