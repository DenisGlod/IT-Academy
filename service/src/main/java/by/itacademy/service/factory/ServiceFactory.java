package by.itacademy.service.factory;

import by.itacademy.service.UserService;

public abstract class ServiceFactory {
    public abstract UserService getUserService();

    public static ServiceFactory getFactory() {
        return new ServiceFactoryImpl();
    }
}
