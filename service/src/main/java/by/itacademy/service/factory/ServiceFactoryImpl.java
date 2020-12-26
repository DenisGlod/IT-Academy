package by.itacademy.service.factory;

import by.itacademy.service.UserService;
import by.itacademy.service.impl.UserServiceImpl;

public class ServiceFactoryImpl extends ServiceFactory {
    @Override
    public UserService getUserService() {
        return new UserServiceImpl();
    }
}
