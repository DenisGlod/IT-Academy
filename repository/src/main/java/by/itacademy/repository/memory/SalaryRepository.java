package by.itacademy.repository.memory;

import by.itacademy.model.Salary;

import java.util.List;
import java.util.Optional;

public interface SalaryRepository {
    List<Salary> findAll();

    Optional<Salary> findById(Long id);

    Salary save(Salary salary);

    Salary remove(Salary salary);
}
