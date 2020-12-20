package by.itacademy.repository.impl;

import by.itacademy.model.Rating;
import by.itacademy.repository.RatingRepository;

import java.util.List;
import java.util.Optional;

public class RatingRepositoryImpl implements RatingRepository {
    @Override
    public List<Rating> findAll() {
        return null;
    }

    @Override
    public Optional<Rating> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Rating save(Rating rating) {
        return null;
    }

    @Override
    public Rating remove(Rating rating) {
        return null;
    }
}
