package ru.job4j.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import ru.job4j.auth.model.Employee;
import ru.job4j.auth.model.Person;
import ru.job4j.auth.service.EmployeeService;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private static final String API = "http://localhost:8080/persons/";
    private static final String API_ID = "http://localhost:8080/persons/{id}";
    @Autowired
    private final EmployeeService employeeService;
    @Autowired
    private RestTemplate rest;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/")
    public List<Employee> findAll() {
        List<Employee> employeeList = employeeService.findAll();
        List<Person> persons = rest.exchange(
                API,
                HttpMethod.GET, null, new ParameterizedTypeReference<List<Person>>() {
                }
        ).getBody();
        for (int i = 0; i < Objects.requireNonNull(persons).size(); i++) {
            Employee employee = employeeList.get(i);
            employee.setPerson(persons.get(i));
            employeeList.set(i, employee);
        }
        return employeeList;
    }

    @PostMapping("/")
    public ResponseEntity<Person> create(@RequestBody Person person) {
        Person personSave = rest.postForObject(API, person, Person.class);
        Employee employee = new Employee();
        employee.setFirstName("Add new name");
        employee.setSurname("Add new surname");
        employee.setIndividualTaxNumber(4242423);
        employeeService.create(employee);
        return new ResponseEntity<>(
                personSave,
                HttpStatus.CREATED
        );
    }

    @PutMapping("/")
    public ResponseEntity<Void> update(@RequestBody Person person) {
        rest.put(API, person);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        rest.delete(API_ID, id);
        return ResponseEntity.ok().build();
    }
}
