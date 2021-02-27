package by.freebook.dao.repository;

import by.freebook.dao.entity.User;

import java.util.Optional;

public interface UserRepository {
    Optional<User> findUserByLoginPassword(User entity);
}
