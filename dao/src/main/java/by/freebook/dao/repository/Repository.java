package by.freebook.dao.repository;

import java.util.List;
import java.util.Optional;

public interface Repository<T> {
    List<T> findAll();

    Optional<T> find(Long id);

    Optional<T> save(T entity);

    Optional<T> update(T entity);

    Optional<T> remove(Long id);
}
