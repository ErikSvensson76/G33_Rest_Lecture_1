package se.lexicon.java_33_first_rest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.lexicon.java_33_first_rest.model.Person;
import se.lexicon.java_33_first_rest.service.PeopleService;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class PeopleController {

    private final PeopleService peopleService;

    @GetMapping("/api/v1/people")
    public ResponseEntity<List<Person>> find(){
        return ResponseEntity.ok(peopleService.findAll());
    }

    @PostMapping("/api/v1/people")
    public ResponseEntity<Person> create(@RequestBody Person person){
        return ResponseEntity.created(URI.create("localhost:8080/api/v1/people/"+person.getId()))
                .body(peopleService.create(person));
    }

    @GetMapping("/api/v1/people/{id}")
    public ResponseEntity<Person> findById(@PathVariable("id") Integer id){

        Person person = peopleService.findById(id);

        return person != null ? ResponseEntity.ok(person) : ResponseEntity.notFound().build();
    }

    @PutMapping("/api/v1/people/{id}")
    public ResponseEntity<Person> update(@PathVariable("id") Integer id, @RequestBody Person inData){

        Person updated = peopleService.update(id, inData);

        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/api/v1/people/{id}")
    public ResponseEntity<?> deletePerson(@PathVariable("id") Integer id){
        boolean deleted = peopleService.delete(id);
        return deleted ? ResponseEntity.ok("Successfully deleted") : ResponseEntity.notFound().build();
    }

}
