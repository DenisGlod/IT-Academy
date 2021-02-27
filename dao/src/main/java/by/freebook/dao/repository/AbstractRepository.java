package by.freebook.dao.repository;

import by.freebook.dao.util.EntityManagerHelper;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Slf4j
public abstract class AbstractRepository<T> implements Repository<T> {

    private final EntityManagerHelper helper = EntityManagerHelper.getInstance();

    private static final String ID = "id";

    protected abstract TypedQuery<T> findAllQuery();

    protected abstract TypedQuery<T> findQuery();

    @Override
    public List<T> findAll() {
        List<T> resultList = null;
        var em = helper.getEntityManager();
        try {
            em.getTransaction().begin();
            resultList = findAllQuery().getResultList();
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            log.error(e.getMessage(), e);
        } finally {
            em.close();
        }
        return resultList;
    }

    @Override
    public Optional<T> find(Long id) {
        var em = helper.getEntityManager();
        T result = null;
        try {
            em.getTransaction().begin();
            result = findQuery()
                    .setParameter(ID, id)
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

    @Override
    public Optional<T> save(T entity) {
        var em = helper.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            log.error(e.getMessage(), e);
        } finally {
            em.close();
        }
        return Optional.of(entity);
    }

    @Override
    public Optional<T> update(T entity) {
        var em = helper.getEntityManager();
        try {
            em.getTransaction().begin();
            entity = em.merge(entity);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            log.error(e.getMessage(), e);
        } finally {
            em.close();
        }
        return Optional.of(entity);
    }

    @Override
    public Optional<T> remove(Long id) {
        Optional<T> result = Optional.empty();
        var em = helper.getEntityManager();
        try {
            em.getTransaction().begin();
            result = find(id);
            result.ifPresent(em::remove);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            log.error(e.getMessage(), e);
        } finally {
            em.close();
        }
        return result;
    }
}
