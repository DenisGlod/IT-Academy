package by.itacademy.repository.memory.impl;

import by.itacademy.model.Rating;
import by.itacademy.repository.memory.RatingRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class RatingRepositoryImpl implements RatingRepository {
    private Map<Long, Rating> ratingMap;

    private RatingRepositoryImpl() {
        ratingMap = new ConcurrentHashMap<>();
    }

    private static class RatingRepositoryHelper {
        private static final RatingRepositoryImpl INSTANCE = new RatingRepositoryImpl();
    }

    public static RatingRepository getInstance() {
        return RatingRepositoryHelper.INSTANCE;
    }

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
