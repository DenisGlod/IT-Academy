package by.itacademy.repository;

import by.itacademy.model.Group;

import java.util.List;
import java.util.Optional;

public interface GroupRepository {
    List<Group> findAll();

    Optional<Group> findById(Long id);

    Group save(Group group);

    Group remove(Group group);
}