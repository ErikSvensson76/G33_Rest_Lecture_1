package se.lexicon.java_33_first_rest.service;

import se.lexicon.java_33_first_rest.model.Person;

import java.util.List;

public interface PeopleService {
    Person findById(Integer id);

    List<Person> findAll();

    Person create(Person person);

    Person update(Integer id, Person person);

    boolean delete(Integer id);
}
