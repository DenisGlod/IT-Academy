package by.itacademy.repository.memory.impl;

import by.itacademy.model.Role;
import by.itacademy.model.User;
import by.itacademy.repository.memory.UserRepository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class UserRepositoryImpl implements UserRepository {
    private final Map<Long, User> userMap;

    private UserRepositoryImpl() {
        userMap = new ConcurrentHashMap<>();
        initUserRepository().forEach(user -> userMap.put(user.getId(), user));
    }

    private static class UserRepositoryHelper {
        private static final UserRepositoryImpl INSTANCE = new UserRepositoryImpl();
    }

    public static UserRepository getInstance() {
        return UserRepositoryHelper.INSTANCE;
    }

    private List<User> initUserRepository() {
        return List.of(
                new User(1L, "administrator", "administrator", "FIO", 30, Role.ADMINISTRATOR),
                new User(2L, "teacher1", "teacher1", "FIO", 54, Role.TEACHER),
                new User(3L, "teacher2", "teacher2", "FIO", 51, Role.TEACHER),
                new User(4L, "user1", "user1", "FIO", 22, Role.STUDENT),
                new User(5L, "user2", "user2", "FIO", 23, Role.STUDENT),
                new User(6L, "user3", "user3", "FIO", 24, Role.STUDENT)
        );
    }

    @Override
    public List<User> findAll() {
        return List.copyOf(userMap.values());
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.ofNullable(userMap.get(id));
    }

    @Override
    public Optional<User> findByLoginPass(String login, String pass) {
        for (User userItem : userMap.values()) {
            if (login.equals(userItem.getLogin()) && pass.equals(userItem.getPassword())) {
                return Optional.of(userItem);
            }
        }
        return Optional.empty();
    }

    @Override
    public User save(User user) {
        if (Objects.isNull(user.getId())) {
            user.setId(new Random().nextLong());
        }
        return userMap.put(user.getId(), user);
    }

    @Override
    public User remove(User user) {
        return userMap.remove(user.getId());
    }
}
