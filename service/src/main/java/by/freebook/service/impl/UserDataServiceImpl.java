package by.freebook.service.impl;

import by.freebook.dao.entity.UserData;
import by.freebook.dao.repository.impl.UserDataRepositoryImpl;
import by.freebook.service.UserDataService;
import by.freebook.service.bean.UserDataBean;
import by.freebook.service.util.Converter;

import java.util.List;
import java.util.Optional;

public class UserDataServiceImpl implements UserDataService {

    @Override
    public List<UserDataBean> getAllUserData() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Optional<UserDataBean> findById(Long id) {
        Optional<UserData> find = UserDataRepositoryImpl.getInstance().find(id);
        return find.map(Converter::userDataEntityToUserDataBean);
    }

    @Override
    public Optional<UserDataBean> save(UserDataBean bean) {
        UserData entity = Converter.userDataBeanToUserDataEntity(bean);
        Optional<UserData> save;
        if (entity.getId() == null) {
            save = UserDataRepositoryImpl.getInstance().save(entity);
        } else {
            save = UserDataRepositoryImpl.getInstance().update(entity);
        }
        return save.map(Converter::userDataEntityToUserDataBean);
    }

    @Override
    public Optional<UserDataBean> delete(UserDataBean bean) {
        // TODO Auto-generated method stub
        return null;
    }

}
