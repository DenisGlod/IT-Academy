package by.itacademy.repository.factory;

import by.itacademy.repository.memory.*;
import by.itacademy.repository.memory.impl.*;

public class MemoryFactory extends RepositoryFactory {
    @Override
    public GroupRepository getGroupRepository() {
        return GroupRepositoryImpl.getInstance();
    }

    @Override
    public RatingRepository getRatingRepository() {
        return RatingRepositoryImpl.getInstance();
    }

    @Override
    public SalaryRepository getSalaryRepository() {
        return SalaryRepositoryImpl.getInstance();
    }

    @Override
    public TopicRepository getTopicRepository() {
        return TopicRepositoryImpl.getInstance();
    }

    @Override
    public UserRepository getUserRepository() {
        return UserRepositoryImpl.getInstance();
    }
}
