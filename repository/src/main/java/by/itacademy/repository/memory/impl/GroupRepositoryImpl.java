package by.itacademy.repository.memory.impl;

import by.itacademy.model.Group;
import by.itacademy.repository.memory.GroupRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class GroupRepositoryImpl implements GroupRepository {
    private Map<Long, Group> groupMap;

    private GroupRepositoryImpl() {
        groupMap = new ConcurrentHashMap<>();
    }

    private static class GroupRepositoryHelper {
        private static final GroupRepositoryImpl INSTANCE = new GroupRepositoryImpl();
    }

    public static GroupRepository getInstance() {
        return GroupRepositoryHelper.INSTANCE;
    }

    @Override
    public List<Group> findAll() {
        return List.copyOf(groupMap.values());
    }

    @Override
    public Optional<Group> findById(Long id) {
        return Optional.ofNullable(groupMap.get(id));
    }

    @Override
    public Group save(Group group) {
        if (groupMap.containsKey(group.getId())) {
            return groupMap.replace(group.getId(), group);
        }
        return groupMap.put(group.getId(), group);
    }

    @Override
    public Group remove(Group group) {
        return groupMap.remove(group.getId());
    }
}
