package by.itacademy.repository.memory.impl;

import by.itacademy.model.Group;
import by.itacademy.repository.memory.GroupRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class GroupRepositoryImpl implements GroupRepository {
    private final Map<Long, Group> GROUP_MAP;

    private GroupRepositoryImpl() {
        GROUP_MAP = new ConcurrentHashMap<>();
    }

    private static class GroupRepositoryHelper {
        private static final GroupRepositoryImpl INSTANCE = new GroupRepositoryImpl();
    }

    public static GroupRepository getInstance() {
        return GroupRepositoryHelper.INSTANCE;
    }

    @Override
    public List<Group> findAll() {
        return List.copyOf(GROUP_MAP.values());
    }

    @Override
    public Optional<Group> findById(Long id) {
        return Optional.ofNullable(GROUP_MAP.get(id));
    }

    @Override
    public Group save(Group group) {
        if (GROUP_MAP.containsKey(group.getId())) {
            return GROUP_MAP.replace(group.getId(), group);
        }
        return GROUP_MAP.put(group.getId(), group);
    }

    @Override
    public Group remove(Group group) {
        return GROUP_MAP.remove(group.getId());
    }
}
