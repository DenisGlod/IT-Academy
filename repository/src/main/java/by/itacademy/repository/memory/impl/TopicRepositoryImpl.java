package by.itacademy.repository.memory.impl;

import by.itacademy.model.Topic;
import by.itacademy.repository.memory.TopicRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class TopicRepositoryImpl implements TopicRepository {
    private final Map<Long, Topic> TOPIC_MAP;

    private TopicRepositoryImpl() {
        TOPIC_MAP = new ConcurrentHashMap<>();
        initTopicRepository().forEach(topic -> TOPIC_MAP.put(topic.getId(), topic));
    }

    private static class TopicRepositoryHelper {
        private static final TopicRepositoryImpl INSTANCE = new TopicRepositoryImpl();
    }

    public static TopicRepository getInstance() {
        return TopicRepositoryHelper.INSTANCE;
    }

    private List<Topic> initTopicRepository() {
        return List.of(new Topic(1L, "Введение в сервлеты"),
                new Topic(2L, "Как работает сервлет"),
                new Topic(3L, "Получение данных в сервлете"),
                new Topic(4L, "Переадресация и перенаправление запроса"),
                new Topic(5L, "web.xml и маппинг сервлетов"),
                new Topic(6L, "Куки"),
                new Topic(7L, "Сессии"),
                new Topic(8L, "Основы синтаксиса JSP"));
    }

    @Override
    public List<Topic> findAll() {
        return List.copyOf(TOPIC_MAP.values());
    }

    @Override
    public Optional<Topic> findById(Long id) {
        return Optional.ofNullable(TOPIC_MAP.get(id));
    }

    @Override
    public Topic save(Topic topic) {
        if (TOPIC_MAP.containsKey(topic.getId())) {
            return TOPIC_MAP.replace(topic.getId(), topic);
        }
        return TOPIC_MAP.put(topic.getId(), topic);
    }

    @Override
    public Topic remove(Topic topic) {
        return TOPIC_MAP.remove(topic.getId());
    }
}
