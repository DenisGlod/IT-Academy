package by.freebook.dao.repository;

import by.freebook.dao.model.User;

import java.util.Optional;

public interface UserRepository {
    Optional<User> findUserByLoginPassword(User entity);
}
