package by.itacademy.repository.memory.impl;

import by.itacademy.model.Group;
import by.itacademy.repository.memory.GroupRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class GroupRepositoryImpl implements GroupRepository {
    private final Map<Long, Group> GROUP_MAP;

    private GroupRepositoryImpl() {
        GROUP_MAP = new ConcurrentHashMap<>();
        initGroupRepository().forEach(item -> GROUP_MAP.put(item.getId(), item));
    }

    private static class GroupRepositoryHelper {
        private static final GroupRepositoryImpl INSTANCE = new GroupRepositoryImpl();
    }

    public static GroupRepository getInstance() {
        return GroupRepositoryHelper.INSTANCE;
    }

    private List<Group> initGroupRepository() {
        return List.of(
                new Group(1L, List.of(4L, 5L, 6L), List.of(1L, 2L, 3L), 2L),
                new Group(2L, List.of(7L, 8L), List.of(1L, 2L, 3L), 3L)
        );
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

    @Override
    public List<Group> findGroupByUserId(Long userId) {
        var groupList = new ArrayList<Group>();
        GROUP_MAP.forEach((key, group) -> {
            if (group.getUsers().contains(userId)) {
                groupList.add(group);
            }
        });
        return groupList;
    }
}
