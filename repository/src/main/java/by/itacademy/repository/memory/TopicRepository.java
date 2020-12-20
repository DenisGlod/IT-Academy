package by.itacademy.repository.memory;

import by.itacademy.model.Topic;

import java.util.List;
import java.util.Optional;

public interface TopicRepository {
    List<Topic> findAll();

    Optional<Topic> findById(Long id);

    Topic save(Topic topic);

    Topic remove(Topic topic);

}
