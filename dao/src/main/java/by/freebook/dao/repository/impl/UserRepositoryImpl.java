package by.freebook.dao.repository.impl;

import by.freebook.dao.entity.User;
import by.freebook.dao.repository.AbstractRepository;
import by.freebook.dao.repository.UserRepository;
import by.freebook.dao.util.EntityManagerHelper;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.TypedQuery;
import java.util.Optional;

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

    @Override
    public Optional<User> findUserByLoginPassword(User entity) {
        var em = helper.getEntityManager();
        User result = null;
        try {
            em.getTransaction().begin();
            result = em.createQuery("from User where email = :email and password = :password", User.class)
                    .setParameter("email", entity.getEmail())
                    .setParameter("password", entity.getPassword())
                    .getSingleResult();
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            log.error(e.getMessage(), e);
        } finally {
            em.close();
        }
        return Optional.ofNullable(result);
    }

    private static class UserRepositoryImplHolder {
        private static final UserRepositoryImpl HOLDER_INSTANCE = new UserRepositoryImpl();
    }

    public static UserRepositoryImpl getInstance() {
        return UserRepositoryImplHolder.HOLDER_INSTANCE;
    }

}
