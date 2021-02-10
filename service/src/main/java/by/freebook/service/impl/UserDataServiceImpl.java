package by.freebook.service.impl;

import java.util.List;
import java.util.Optional;

import by.freebook.dao.model.UserData;
import by.freebook.dao.repository.impl.UserDataRepositoryImpl;
import by.freebook.service.UserDataService;
import by.freebook.service.bean.UserDataBean;
import by.freebook.service.util.Converter;

public class UserDataServiceImpl implements UserDataService {

    @Override
    public List<UserDataBean> getAllUserData() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public Optional<UserDataBean> findById(Integer id) {
	Optional<UserData> find = UserDataRepositoryImpl.getInstance().find(id);
	if (find.isPresent()) {
	    return Optional.of(Converter.userDataEntityToUserDataBean(find.get()));
	}
	return Optional.empty();
    }

    @Override
    public Optional<UserDataBean> save(UserDataBean bean) {
	UserData entity = Converter.userDataBeanToUserDataEntity(bean);
	Optional<UserData> save = UserDataRepositoryImpl.getInstance().save(entity);
	if (save.isPresent()) {
	    return Optional.of(Converter.userDataEntityToUserDataBean(save.get()));
	}
	return Optional.empty();
    }

    @Override
    public Optional<UserDataBean> delete(UserDataBean bean) {
	// TODO Auto-generated method stub
	return null;
    }

}
