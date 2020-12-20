package by.itacademy.repository.impl;

import by.itacademy.model.Topic;
import by.itacademy.repository.TopicRepository;

import java.util.List;
import java.util.Optional;

public class TopicRepositoryImpl implements TopicRepository {
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
