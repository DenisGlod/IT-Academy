package by.freebook.dao.repository;

import by.freebook.dao.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByEmailAndPassword(String email, String password);

    Optional<User> findUserById(Long id);

    Optional<User> deleteUserById(Long id);

}
