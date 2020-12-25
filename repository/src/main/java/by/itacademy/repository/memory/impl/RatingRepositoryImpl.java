package by.itacademy.repository.memory.impl;

import by.itacademy.model.Rating;
import by.itacademy.repository.memory.RatingRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class RatingRepositoryImpl implements RatingRepository {
    private final Map<Long, Rating> RATING_MAP;

    private RatingRepositoryImpl() {
        RATING_MAP = new ConcurrentHashMap<>();
        initSalaryRepository().forEach(rating -> RATING_MAP.put(rating.getId(), rating));
    }

    private static class RatingRepositoryHelper {
        private static final RatingRepositoryImpl INSTANCE = new RatingRepositoryImpl();
    }

    public static RatingRepository getInstance() {
        return RatingRepositoryHelper.INSTANCE;
    }

    private List<Rating> initSalaryRepository() {
        return List.of(
                new Rating(1L, 4L, 1L, 50),
                new Rating(2L, 4L, 2L, 62),
                new Rating(3L, 4L, 3L, 32),
                new Rating(4L, 5L, 1L, 13),
                new Rating(5L, 5L, 2L, 12),
                new Rating(6L, 5L, 3L, 21)
        );
    }

    @Override
    public List<Rating> findAll() {
        return List.copyOf(RATING_MAP.values());
    }

    @Override
    public Optional<Rating> findById(Long id) {
        return Optional.ofNullable(RATING_MAP.get(id));
    }

    @Override
    public Rating save(Rating rating) {
        if (RATING_MAP.containsKey(rating.getId())) {
            return RATING_MAP.replace(rating.getId(), rating);
        }
        return RATING_MAP.put(rating.getId(), rating);
    }

    @Override
    public Rating remove(Rating rating) {
        return RATING_MAP.remove(rating.getId());
    }

    @Override
    public Rating findByTopicId(Long id) {
        for (Rating item : RATING_MAP.values()) {
            if (item.getTopicId() == id) {
                return item;
            }
        }
        return null;
    }
}
