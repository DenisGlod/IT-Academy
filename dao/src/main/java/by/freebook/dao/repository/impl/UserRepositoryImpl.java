package by.freebook.dao.repository.impl;

import by.freebook.dao.entity.User;
import by.freebook.dao.repository.AbstractRepository;
import by.freebook.dao.repository.UserRepository;
import by.freebook.dao.util.EntityManagerHelper;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.TypedQuery;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserRepositoryImpl extends AbstractRepository<User> implements UserRepository {
    private final EntityManagerHelper helper = EntityManagerHelper.getInstance();

    @Override
    protected TypedQuery<User> findAllQuery() {
        return helper.getEntityManager()
                .createQuery("from User", User.class);
    }

    @Override
    protected TypedQuery<User> findQuery() {
        return helper.getEntityManager()
                .createQuery("from User where id = :id", User.class);
    }

    private static class UserRepositoryImplHolder {
        private static final UserRepositoryImpl HOLDER_INSTANCE = new UserRepositoryImpl();
    }

    public static UserRepositoryImpl getInstance() {
        return UserRepositoryImplHolder.HOLDER_INSTANCE;
    }

}
