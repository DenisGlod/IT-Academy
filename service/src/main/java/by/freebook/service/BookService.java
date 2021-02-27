package by.freebook.service;

import by.freebook.service.bean.BookBean;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<BookBean> getAllBook();

    Optional<BookBean> findById(Integer id);

    Optional<BookBean> save(BookBean bean);

    Optional<BookBean> delete(BookBean bean);
}