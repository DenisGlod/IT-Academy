package by.itacademy.repository.memory;

import by.itacademy.model.Rating;

import java.util.List;
import java.util.Optional;

public interface RatingRepository {
    List<Rating> findAll();

    Optional<Rating> findById(Long id);

    Rating save(Rating rating);

    Rating remove(Rating rating);
}
