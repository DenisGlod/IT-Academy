package by.itacademy.repository.memory.impl;

import by.itacademy.model.Role;
import by.itacademy.model.User;
import by.itacademy.repository.memory.UserRepository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class UserRepositoryImpl implements UserRepository {
    private final Map<Long, User> USER_MAP;

    private UserRepositoryImpl() {
        USER_MAP = new ConcurrentHashMap<>();
        initUserRepository().forEach(user -> USER_MAP.put(user.getId(), user));
    }

    private static class UserRepositoryHelper {
        private static final UserRepositoryImpl INSTANCE = new UserRepositoryImpl();
    }

    public static UserRepository getInstance() {
        return UserRepositoryHelper.INSTANCE;
    }

    private List<User> initUserRepository() {
        return List.of(
                new User(1L, "administrator", "administrator", "Иванов Иван Иванович", 30, Role.ADMIN),
                new User(2L, "teacher1", "teacher1", "FIO", 54, Role.TEACHER),
                new User(3L, "teacher2", "teacher2", "FIO", 51, Role.TEACHER),
                new User(4L, "user1", "user1", "Петров Иван Иванович", 22, Role.STUDENT),
                new User(5L, "user2", "user2", "Сидоров Виталий Павлович", 23, Role.STUDENT),
                new User(6L, "user3", "user3", "Липский Валентин Сергеевич", 24, Role.STUDENT),
                new User(7L, "user4", "user4", "Генадий Иван Сергеевич", 21, Role.STUDENT),
                new User(8L, "user5", "user5", "Дубский Кирил Иванович", 24, Role.STUDENT)
        );
    }

    @Override
    public List<User> findAll() {
        return List.copyOf(USER_MAP.values());
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.ofNullable(USER_MAP.get(id));
    }

    @Override
    public Optional<User> findByLoginPass(String login, String pass) {
        for (User userItem : USER_MAP.values()) {
            if (userItem.getLogin().equals(login) && userItem.getPassword().equals(pass)) {
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
        return USER_MAP.put(user.getId(), user);
    }

    @Override
    public User remove(User user) {
        return USER_MAP.remove(user.getId());
    }
}
