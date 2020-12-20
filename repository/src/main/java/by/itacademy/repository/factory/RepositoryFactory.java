package by.itacademy.repository.factory;

import by.itacademy.repository.memory.*;

public abstract class RepositoryFactory {
    public abstract GroupRepository getGroupRepository();

    public abstract RatingRepository getRatingRepository();

    public abstract SalaryRepository getSalaryRepository();

    public abstract TopicRepository getTopicRepository();

    public abstract UserRepository getUserRepository();

    public static RepositoryFactory getFactory() {
        return getFactory(StorageType.MEMORY);
    }

    public static RepositoryFactory getFactory(StorageType type) {
        switch (type) {
            case MEMORY:
                return new MemoryFactory();
            default:
                throw new UnsupportedOperationException();
        }
    }
}
