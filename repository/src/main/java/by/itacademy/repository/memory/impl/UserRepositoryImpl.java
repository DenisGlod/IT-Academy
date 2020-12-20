package by.itacademy.repository.memory.impl;

import by.itacademy.model.User;
import by.itacademy.repository.memory.UserRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class UserRepositoryImpl implements UserRepository {
    private Map<Long, User> userMap;

    private UserRepositoryImpl() {
        userMap = new ConcurrentHashMap<>();
    }

    private static class UserRepositoryHelper {
        private static final UserRepositoryImpl INSTANCE = new UserRepositoryImpl();
    }

    public static UserRepository getInstance() {
        return UserRepositoryHelper.INSTANCE;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public User remove(User user) {
        return null;
    }
}
