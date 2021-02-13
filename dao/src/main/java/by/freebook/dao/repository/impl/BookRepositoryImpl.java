package by.freebook.dao.repository.impl;

import by.freebook.dao.entity.Book;
import by.freebook.dao.repository.AbstractRepository;
import by.freebook.dao.util.EntityManagerHelper;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.TypedQuery;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BookRepositoryImpl extends AbstractRepository<Book> {
    private final EntityManagerHelper helper = EntityManagerHelper.getInstance();

    @Override
    protected TypedQuery<Book> findAllQuery() {
        return helper.getEntityManager()
                .createQuery("from Book", Book.class);
    }

    @Override
    protected TypedQuery<Book> findQuery() {
        return helper.getEntityManager()
                .createQuery("from Book where id = :id", Book.class);
    }

    private static class BookRepositoryImplHolder {
        private static final BookRepositoryImpl HOLDER_INSTANCE = new BookRepositoryImpl();
    }

    public static BookRepositoryImpl getInstance() {
        return BookRepositoryImplHolder.HOLDER_INSTANCE;
    }
}
