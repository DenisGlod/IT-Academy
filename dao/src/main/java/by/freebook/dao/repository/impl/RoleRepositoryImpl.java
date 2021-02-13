package by.freebook.dao.repository.impl;

import by.freebook.dao.entity.Role;
import by.freebook.dao.repository.AbstractRepository;
import by.freebook.dao.util.EntityManagerHelper;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.TypedQuery;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RoleRepositoryImpl extends AbstractRepository<Role> {
    private final EntityManagerHelper helper = EntityManagerHelper.getInstance();

    @Override
    protected TypedQuery<Role> findAllQuery() {
        return helper.getEntityManager()
                .createQuery("from Role", Role.class);
    }

    @Override
    protected TypedQuery<Role> findQuery() {
        return helper.getEntityManager()
                .createQuery("from Role where id = :id", Role.class);
    }

    private static class RoleRepositoryImplHolder {
        private static final RoleRepositoryImpl HOLDER_INSTANCE = new RoleRepositoryImpl();
    }

    public static RoleRepositoryImpl getInstance() {
        return RoleRepositoryImplHolder.HOLDER_INSTANCE;
    }

}
