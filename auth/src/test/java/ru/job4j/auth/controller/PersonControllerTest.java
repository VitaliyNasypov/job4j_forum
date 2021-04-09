package ru.job4j.auth.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import ru.job4j.auth.model.Person;
import ru.job4j.auth.repository.PersonRepository;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PersonControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper mapper;
    @Captor
    private ArgumentCaptor<Person> argumentCaptorPerson;
    @Autowired
    private PersonRepository personRepository;

    @Test
    public void findAll() throws Exception {
        List<Person> persons = List.of(
                new Person(1, "first", "123"),
                new Person(2, "second", "123"),
                new Person(3, "third", "123")
        );
        mockMvc.perform(get("/persons/"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(mapper.writeValueAsString(persons)));
    }

    @Test
    public void findById() throws Exception {
        Person person = new Person(1, "first", "123");
        mockMvc.perform(get("/persons/{id}", 1))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(mapper.writeValueAsString(person)));
    }

    @Test
    public void create() throws Exception {
        Person person = new Person();
        person.setLogin("TestCreate");
        person.setPassword("123");
        mockMvc.perform(post("/persons/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(person)))
                .andExpect(status().isCreated());
        Assertions.assertEquals(4, personRepository.findById(4).orElse(new Person()).getId());
        personRepository.deleteById(4);
    }

    @Test
    public void update() throws Exception {
        Person person = new Person();
        person.setLogin("TestUpdate");
        person.setPassword("123");
        person = personRepository.save(person);
        person.setLogin("New TestUpdate");
        mockMvc.perform(put("/persons/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(person)))
                .andExpect(status().isOk());
        personRepository.deleteById(person.getId());
    }

    @Test
    public void deletewqeqe() throws Exception {
        Person person = new Person();
        person.setLogin("TestDelete");
        person.setPassword("123");
        person = personRepository.save(person);
        mockMvc.perform(delete("/persons//{id}", person.getId()))
                .andExpect(status().isOk());
    }
}
