package by.itacademy.repository.memory.impl;

import by.itacademy.model.Salary;
import by.itacademy.repository.memory.SalaryRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class SalaryRepositoryImpl implements SalaryRepository {
    private Map<Long, Salary> salaryMap;

    private SalaryRepositoryImpl() {
        salaryMap = new ConcurrentHashMap<>();
    }

    private static class SalaryRepositoryHelper {
        private static final SalaryRepositoryImpl INSTANCE = new SalaryRepositoryImpl();
    }

    public static SalaryRepository getInstance() {
        return SalaryRepositoryHelper.INSTANCE;
    }

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
