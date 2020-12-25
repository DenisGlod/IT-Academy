package by.itacademy.repository.memory.impl;

import by.itacademy.model.Salary;
import by.itacademy.repository.memory.SalaryRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class SalaryRepositoryImpl implements SalaryRepository {
    private final Map<Long, Salary> SALARY_MAP;

    private SalaryRepositoryImpl() {
        SALARY_MAP = new ConcurrentHashMap<>();
    }

    private static class SalaryRepositoryHelper {
        private static final SalaryRepositoryImpl INSTANCE = new SalaryRepositoryImpl();
    }

    public static SalaryRepository getInstance() {
        return SalaryRepositoryHelper.INSTANCE;
    }

    @Override
    public List<Salary> findAll() {
        return List.copyOf(SALARY_MAP.values());
    }

    @Override
    public Optional<Salary> findById(Long id) {
        return Optional.ofNullable(SALARY_MAP.get(id));
    }

    @Override
    public Salary save(Salary salary) {
        if (SALARY_MAP.containsKey(salary.getId())) {
            return SALARY_MAP.replace(salary.getId(), salary);
        }
        return SALARY_MAP.put(salary.getId(), salary);
    }

    @Override
    public Salary remove(Salary salary) {
        return SALARY_MAP.remove(salary.getId());
    }
}
