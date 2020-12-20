package by.itacademy.repository.impl;

import by.itacademy.model.Group;
import by.itacademy.repository.GroupRepository;

import java.util.List;
import java.util.Optional;

public class GroupRepositoryImpl implements GroupRepository {
    @Override
    public List<Group> findAll() {
        return null;
    }

    @Override
    public Optional<Group> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Group save(Group group) {
        return null;
    }

    @Override
    public Group remove(Group group) {
        return null;
    }
}
