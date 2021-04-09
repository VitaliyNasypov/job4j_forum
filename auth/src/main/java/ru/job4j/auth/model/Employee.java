package ru.job4j.auth.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "EMPLOYEES")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "surname")
    private String surname;
    @Column(name = "individual_tax_number")
    private int individualTaxNumber;
    @Column(name = "date_employment")
    private LocalDateTime dateEmployment;
    @Transient
    private Person person;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Employee employee = (Employee) o;
        return id == employee.id
                && individualTaxNumber == employee.individualTaxNumber
                && Objects.equals(firstName, employee.firstName)
                && Objects.equals(surname, employee.surname)
                && Objects.equals(dateEmployment, employee.dateEmployment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, surname, individualTaxNumber, dateEmployment);
    }
}
