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
        return List.copyOf(topicMap.values());
    }

    @Override
    public Optional<Topic> findById(Long id) {
        return Optional.ofNullable(topicMap.get(id));
    }

    @Override
    public Topic save(Topic topic) {
        if (topicMap.containsKey(topic.getId())) {
            return topicMap.replace(topic.getId(), topic);
        }
        return topicMap.put(topic.getId(), topic);
    }

    @Override
    public Topic remove(Topic topic) {
        return topicMap.remove(topic.getId());
    }
}
