package by.freebook.dao.repository.impl;

import by.freebook.dao.entity.UserData;
import by.freebook.dao.repository.AbstractRepository;
import by.freebook.dao.util.EntityManagerHelper;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.TypedQuery;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserDataRepositoryImpl extends AbstractRepository<UserData> {
    private final EntityManagerHelper helper = EntityManagerHelper.getInstance();

    @Override
    protected TypedQuery<UserData> findAllQuery() {
        return helper.getEntityManager()
                .createQuery("from UserData", UserData.class);
    }

    @Override
    protected TypedQuery<UserData> findQuery() {
        return helper.getEntityManager()
                .createQuery("from UserData where id = :id", UserData.class);
    }

    private static class UserDataRepositoryImplHolder {
        private static final UserDataRepositoryImpl HOLDER_INSTANCE = new UserDataRepositoryImpl();
    }

    public static UserDataRepositoryImpl getInstance() {
        return UserDataRepositoryImplHolder.HOLDER_INSTANCE;
    }

}
