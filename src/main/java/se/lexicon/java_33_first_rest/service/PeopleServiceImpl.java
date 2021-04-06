package se.lexicon.java_33_first_rest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import se.lexicon.java_33_first_rest.data.PersonIdSequencer;
import se.lexicon.java_33_first_rest.model.Person;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PeopleServiceImpl implements PeopleService{

    private final PersonIdSequencer sequencer;
    private List<Person> personList = new ArrayList<>();

    @Override
    public Person findById(Integer id){
        for(Person person : personList){
            if(person.getId().equals(id)){
                return person;
            }
        }
        return null;
    }

    @Override
    public List<Person> findAll(){
        return new ArrayList<>(personList);
    }

    @Override
    public Person create(Person person){
        if(person == null) return null;
        if(person.getId() != null){
            throw new IllegalArgumentException("Person is already persisted");
        }

        person.setId(sequencer.getNextId());
        personList.add(person);
        return person;
    }

    @Override
    public Person update(Integer id, Person person){
        if(!id.equals(person.getId())){
            throw new IllegalArgumentException("PathVariable id didnt match person.id");
        }

        Person original =  findById(id);
        if(original == null){
            throw new IllegalArgumentException("Update aborted, could not find Person with id " + id);
        }

        if(!original.getFirstName().equals(person.getFirstName())){
            original.setFirstName(person.getFirstName());
        }
        if(!original.getLastName().equals(person.getLastName())){
            original.setLastName(person.getLastName());
        }
        if(!original.getBirthDate().equals(person.getBirthDate())){
            original.setBirthDate(person.getBirthDate());
        }

        return original;
    }

    @Override
    public boolean delete(Integer id){
        boolean deleted = false;

        Person person = findById(id);
        if(person != null){
            deleted = personList.remove(person);
        }
        return deleted;
    }




}
