package by.freebook.service.factory;

import by.freebook.service.BookService;
import by.freebook.service.UserDataService;
import by.freebook.service.UserService;
import by.freebook.service.impl.BookServiceImpl;
import by.freebook.service.impl.UserDataServiceImpl;
import by.freebook.service.impl.UserServiceImpl;

public class ServiceFactoryIpml extends ServiceFactory {

    @Override
    public UserService getUserService() {
	return new UserServiceImpl();
    }

    @Override
    public BookService getBookService() {
	return new BookServiceImpl();
    }

    @Override
    public UserDataService getUserDataService() {
	return new UserDataServiceImpl();
    }

}
