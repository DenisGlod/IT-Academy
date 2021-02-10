package by.freebook.service;

import by.freebook.service.bean.UserDataBean;

import java.util.List;
import java.util.Optional;

public interface UserDataService {
    List<UserDataBean> getAllUserData();

    Optional<UserDataBean> findById(Integer id);

    Optional<UserDataBean> save(UserDataBean bean);

    Optional<UserDataBean> delete(UserDataBean bean);
}
