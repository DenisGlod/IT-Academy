package by.freebook.dao.repository;

import by.freebook.dao.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.NonNull;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findUserByEmailAndPassword(String email, String password);

    Optional<User> findUserById(Long id);

    Optional<User> deleteUserById(Long id);

    @NonNull
    @Override
    List<User> findAll();

}
