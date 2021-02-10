package by.freebook.dao.repository;

import java.util.Optional;

import by.freebook.dao.model.User;

public interface UserRepository {
    Optional<User> findUserByLoginPassword(User entity);
}
