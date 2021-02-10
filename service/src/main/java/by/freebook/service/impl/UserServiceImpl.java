package by.freebook.service.impl;

import java.util.List;
import java.util.Optional;

import by.freebook.dao.model.User;
import by.freebook.dao.repository.impl.UserRepositoryImpl;
import by.freebook.service.UserService;
import by.freebook.service.bean.UserBean;
import by.freebook.service.util.Converter;

public class UserServiceImpl implements UserService {

    @Override
    public List<UserBean> getAllUser() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public Optional<UserBean> findById(Integer id) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public Optional<UserBean> login(UserBean bean) {
	UserRepositoryImpl userRepo = UserRepositoryImpl.getInstance();
	Optional<User> login = userRepo.findUserByLoginPassword(Converter.userBeanToUserEntity(bean));
	if (login.isPresent()) {
	    bean = Converter.userEntityToUserBean(login.get());
	    return Optional.of(bean);
	}
	return Optional.empty();
    }

    @Override
    public Optional<UserBean> save(UserBean bean) {
	User userEntity = Converter.userBeanToUserEntity(bean);
	Optional<User> save = UserRepositoryImpl.getInstance().save(userEntity);
	if (save.isPresent()) {
	    UserBean userBean = Converter.userEntityToUserBean(save.get());
	    return Optional.of(userBean);
	}
	return Optional.empty();
    }

    @Override
    public Optional<UserBean> delete(UserBean bean) {
	// TODO Auto-generated method stub
	return null;
    }

}
