package ru.job4j.auth.service;

import ru.job4j.auth.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    List<Employee> findAll();

    Optional<Employee> findById(int id);

    Employee create(Employee employee);

    void update(Employee employee);

    void delete(int id);
}
