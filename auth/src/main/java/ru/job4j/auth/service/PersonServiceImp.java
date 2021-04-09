package ru.job4j.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.job4j.auth.model.Person;
import ru.job4j.auth.repository.PersonRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class PersonServiceImp implements PersonService {
    private final PersonRepository personService;

    @Autowired
    public PersonServiceImp(PersonRepository personService) {
        this.personService = personService;
    }

    @Override
    public List<Person> findAll() {
        return StreamSupport.stream(
                this.personService.findAll().spliterator(), false
        ).collect(Collectors.toList());
    }

    @Override
    public Optional<Person> findById(int id) {
        return personService.findById(id);
    }

    @Override
    public Person create(Person person) {
        return personService.save(person);
    }

    @Override
    public void update(Person person) {
        personService.save(person);
    }

    @Override
    public void delete(int id) {
        personService.deleteById(id);
    }
}
