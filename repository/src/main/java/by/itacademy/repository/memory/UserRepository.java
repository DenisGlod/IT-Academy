package by.itacademy.repository.memory;

import by.itacademy.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    List<User> findAll();

    Optional<User> findById(Long id);

    User save(User user);

    User remove(User user);
}
