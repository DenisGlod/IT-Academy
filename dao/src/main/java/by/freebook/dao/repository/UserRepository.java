package by.freebook.dao.repository;

import by.freebook.dao.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.NonNull;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findUserByEmailAndPassword(String email, String password);

    Optional<User> findUserById(Long id);

    @Override
    @NonNull
    <S extends User> S save(@NonNull S entity);

    Optional<User> updateUserById(Long id);

    Optional<User> deleteUserById(Long id);

    @Override
    @NonNull
    List<User> findAll();

    boolean existsUserById(Long id);
}
