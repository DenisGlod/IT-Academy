package by.freebook.service.factory;

import by.freebook.service.BookService;
import by.freebook.service.UserDataService;
import by.freebook.service.UserService;

public abstract class ServiceFactory {
    
    public abstract UserService getUserService();
    
    public abstract BookService getBookService();
    
    public abstract UserDataService getUserDataService();
    
    public static ServiceFactory getFactory() {
	return new ServiceFactoryIpml();
}

}
