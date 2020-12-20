package by.itacademy.repository.impl;

import by.itacademy.model.Salary;
import by.itacademy.repository.SalaryRepository;

import java.util.List;
import java.util.Optional;

public class SalaryRepositoryImpl implements SalaryRepository {
    @Override
    public List<Salary> findAll() {
        return null;
    }

    @Override
    public Optional<Salary> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Salary save(Salary salary) {
        return null;
    }

    @Override
    public Salary remove(Salary salary) {
        return null;
    }
}
