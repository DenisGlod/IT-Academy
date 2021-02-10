package by.freebook.service.impl;

import java.util.List;
import java.util.Optional;

import by.freebook.dao.model.Book;
import by.freebook.dao.repository.impl.BookRepositoryImpl;
import by.freebook.service.BookService;
import by.freebook.service.bean.BookBean;
import by.freebook.service.util.Converter;

public class BookServiceImpl implements BookService {

    @Override
    public List<BookBean> getAllBook() {
	BookRepositoryImpl bookRepository = BookRepositoryImpl.getInstance();
	List<Book> listBookEntity = bookRepository.findAll();
	List<BookBean> listBookBean = Converter.bookEntityListToBookBeanList(listBookEntity);
	return listBookBean;
    }

    @Override
    public Optional<BookBean> findById(Integer id) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public Optional<BookBean> save(BookBean bean) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public Optional<BookBean> delete(BookBean bean) {
	// TODO Auto-generated method stub
	return null;
    }

}
