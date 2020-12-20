package by.itacademy.repository.memory.impl;

import by.itacademy.model.Topic;
import by.itacademy.repository.memory.TopicRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class TopicRepositoryImpl implements TopicRepository {
    private Map<Long, Topic> topicMap;

    private TopicRepositoryImpl() {
        topicMap = new ConcurrentHashMap<>();
    }

    private static class TopicRepositoryHelper {
        private static final TopicRepositoryImpl INSTANCE = new TopicRepositoryImpl();
    }

    public static TopicRepository getInstance() {
        return TopicRepositoryHelper.INSTANCE;
    }

    @Override
    public List<Topic> findAll() {
        return null;
    }

    @Override
    public Optional<Topic> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Topic save(Topic topic) {
        return null;
    }

    @Override
    public Topic remove(Topic topic) {
        return null;
    }
}
